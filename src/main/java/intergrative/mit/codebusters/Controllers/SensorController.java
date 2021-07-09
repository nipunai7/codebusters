package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Models.Sensor;
import intergrative.mit.codebusters.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SensorController {

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    @Autowired
    private SensorRepo sensorRepo;

    @PostMapping("/addSensor")
    public String saveSensor(@RequestBody Sensor sensor){
        if (sensor.temps.isEmpty()){
            sensor.temps.add(0);
        }
        sensor.setAddDate(timestamp);
        sensor.setLastUpdate(timestamp);
        System.out.println(timestamp);
        try {
            sensorRepo.save(sensor);
            return "Sensor Added: " + sensor.getId();
        }catch (Exception e){
            return e.toString();
        }
    }

    @GetMapping("/listsensors")
    public List<Sensor> getSensors(){
        return sensorRepo.findAll();
    }

    @GetMapping("/listsensors/{id}")
    public Optional<Sensor> getSensor2(@PathVariable String id){
        return sensorRepo.findById(id);
    }

    @DeleteMapping("/del/{id}")
    public String deleteSensor(@PathVariable String id){
        sensorRepo.deleteById(id);
        return "Sensor Deleted: "+id;
    }

    @PatchMapping("/update/{id}/{temp}")
    public String updateSen(@PathVariable String id,@PathVariable double temp,@RequestBody Sensor sensor){
        Optional<Sensor> sensorData = sensorRepo.findById(id);

         if( sensorData.isPresent()){
             Sensor _sensor = sensorData.get();
             _sensor.setTemps(temp,timestamp);
             _sensor.setLastUpdate(timestamp);
             sensorRepo.save(_sensor);
             return "Data added";
         }else{
             return "No sensor detected";
         }

    }

    @PatchMapping("/update/thresholds/{id}")
    public String updateSen2(@PathVariable String id,@RequestBody Sensor sensor){
        Optional<Sensor> sensorData = sensorRepo.findById(id);

        try {
            Sensor _sensor = sensorData.get();
            _sensor.setThreshold1(sensor.getThreshold1());
            _sensor.setThreshold2(sensor.getThreshold2());
            sensorRepo.save(_sensor);
            return "Thresholds Updated";
        }catch (Exception e){
            return  e.toString();
        }
    }



}
