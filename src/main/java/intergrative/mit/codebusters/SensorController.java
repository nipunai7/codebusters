package intergrative.mit.codebusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    private SensorRepo sensorRepo;

    @PostMapping("/addSensor")
    public String saveSensor(@RequestBody Sensor sensor){
        sensorRepo.save(sensor);
        return "Sensor Added: "+sensor.getId();
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



}
