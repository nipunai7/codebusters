package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Models.LightSensor;
import intergrative.mit.codebusters.Models.Sensor;
import intergrative.mit.codebusters.Models.TempSensor;
import intergrative.mit.codebusters.Models.User;
import intergrative.mit.codebusters.SensorRepo;
import intergrative.mit.codebusters.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SensorController {

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());


    @Autowired
    private SensorRepo sensorRepo;

    @Autowired
    private UserRepo userRepo;



    @PostMapping("/addSensor/{user}/Light")
    public String saveSensor(@RequestBody LightSensor sensor, @PathVariable String user){
        Optional<User> userData = userRepo.findById(user);

        User _user = userData.get();
        sensor.setType(sensor.setType());
        sensor.setUserID(user);
        sensor.setAddDate(timeStamp);
        sensor.setLastUpdate(timeStamp);
        System.out.println(timeStamp);
        System.out.println(userData);
        System.out.println(sensor.getId());

        try {
            sensorRepo.save(sensor);
            _user.setSensors(sensor.getId(),timeStamp);
            userRepo.save(_user);
            return "Sensor Added: " + sensor.getId();
        }catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping("/addSensor/{user}/Temp")
    public String saveSensor2(@RequestBody TempSensor sensor,@PathVariable String user){
        Optional<User> userData = userRepo.findById(user);

        if (sensor.temps.isEmpty()){
            sensor.setTemps(0,timeStamp);
        }
        User _user = userData.get();
        sensor.setType(sensor.setType());
        sensor.setUserID(user);
        sensor.setAddDate(timeStamp);
        sensor.setLastUpdate(timeStamp);
        System.out.println(timeStamp);
        System.out.println(userData);
        System.out.println(userRepo);

        try {
            sensorRepo.save(sensor);
            _user.setSensors(sensor.getId(),timeStamp);
            userRepo.save(_user);
            return "Sensor Added: " + sensor.getId();
        }catch (Exception e){
            return e.toString();
        }
    }

    @GetMapping("/{user}/listsensors")
    public List<Sensor> getSensors(@PathVariable String user){
        return sensorRepo.findAll();
    }

    @GetMapping("/{user}/listsensors/{id}")
    public Optional<Sensor> getSensor2(@PathVariable String id,@PathVariable String user){
        return sensorRepo.findById(id);
    }

    @DeleteMapping("/{user}/del/{id}")
    public String deleteSensor(@PathVariable String id){
        sensorRepo.deleteById(id);
        return "Sensor Deleted: "+id;
    }

    @PatchMapping("/{user}/update/{id}/{temp}")
    public String updateSen(@PathVariable String id,@PathVariable double temp,@RequestBody Sensor sensor,@PathVariable String user){
        Optional<Sensor> sensorData = sensorRepo.findById(id);
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

         if( sensorData.isPresent()){
             Sensor _sensor = sensorData.get();
             _sensor.setTemps(temp,timeStamp);
             _sensor.setLastUpdate(timeStamp);
             sensorRepo.save(_sensor);
             return "Data added";
         }else{
             return "No sensor detected";
         }

    }

    @PatchMapping("/{user}/update/all/{id}")
    public String updateSen2(@PathVariable String id,@RequestBody Sensor sensor,@PathVariable String user){
        Optional<Sensor> sensorData = sensorRepo.findById(id);
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        System.out.println(sensorData);

        try {
            Sensor _sensor = sensorData.get();
            _sensor.setName(sensor.getName());
            _sensor.setThreshold1(sensor.getThreshold1());
            _sensor.setThreshold2(sensor.getThreshold2());
            sensorRepo.save(_sensor);
            return "Sensor Data Updated";
        }catch (Exception e){
            return  e.toString();
        }
    }



}
