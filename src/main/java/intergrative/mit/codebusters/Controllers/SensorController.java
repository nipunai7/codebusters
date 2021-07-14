package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Repositories.EmailsentRepo;
import intergrative.mit.codebusters.Models.*;
import intergrative.mit.codebusters.Repositories.SensorRepo;
import intergrative.mit.codebusters.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class SensorController {

    private EmailConfig emailConfig;

    public SensorController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    String timeStamp;


    @Autowired
    private SensorRepo sensorRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailsentRepo emailsentRepo;


    @PostMapping("/addSensor/{user}/Light")
    public String saveSensor(@RequestBody LightSensor sensor, @PathVariable String user, @RequestHeader("Authorization") String Authorization) {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        Optional<UserModel> userData = userRepo.findById(user);

        UserModel _userModel = userData.get();
        sensor.setType(sensor.setType());
        sensor.setUserID(user);
        sensor.setAddDate(timeStamp);
        sensor.setLastUpdate(timeStamp);
        System.out.println(timeStamp);
        System.out.println(userData);
        System.out.println(sensor.getId());

        if (sensor == null){
            return "No details provided";
        }
        try {
            sensorRepo.save(sensor);
            _userModel.setSensors(sensor.getId(), timeStamp);
            userRepo.save(_userModel);
            System.out.println(Authorization);
            return "Sensor Added: " + sensor.getId();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping("/addSensor/{user}/Temp")
    public String saveSensor2(@RequestBody TempSensor sensor, @PathVariable String user) {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
        Optional<UserModel> userData = userRepo.findById(user);

        UserModel _userModel = userData.get();
        sensor.setType(sensor.setType());
        sensor.setUserID(user);
        sensor.setAddDate(timeStamp);
        sensor.setLastUpdate(timeStamp);
        System.out.println(timeStamp);
        System.out.println(userData);
        System.out.println(userRepo);

        try {
            sensorRepo.save(sensor);
            _userModel.setSensors(sensor.getId(), timeStamp);
            userRepo.save(_userModel);
            return "Sensor Added: " + sensor.getId();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("/{user}/listsensors")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Sensor> getSensors(@PathVariable String user) {
        return sensorRepo.findAll();
    }

    @GetMapping("/{user}/listsensors/{id}")
    public Optional<Sensor> getSensor2(@PathVariable String id, @PathVariable String user) {
        return sensorRepo.findById(id);
    }

    @DeleteMapping("/{user}/del/{id}")
    public String deleteSensor(@PathVariable String id) {
        sensorRepo.deleteById(id);
        return "Sensor Deleted: " + id;
    }

    @PatchMapping("/{user}/update/{id}/{temp}")
    public String updateSen(@PathVariable String id, @PathVariable double temp, @PathVariable String user) {
        Optional<Sensor> sensorData = sensorRepo.findById(id);
        Optional<UserModel> userData = userRepo.findById(user);
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

        try {
            Sensor _sensor = sensorData.get();
            UserModel _userModel = userData.get();

            EmailTable emailTable = new EmailTable();
            emailTable.setUserId(_userModel.getUserId());
            emailTable.setSensorId(_sensor.getId());
            emailTable.setTime(timeStamp);
            emailTable.setFrom("sensor@project.com");
            emailTable.setTo(_userModel.getEmail());
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

            mailSender.setHost(this.emailConfig.getHost());
            mailSender.setPort(this.emailConfig.getPort());
            mailSender.setUsername(this.emailConfig.getUsername());
            mailSender.setPassword(this.emailConfig.getPassword());

            if ((temp > _sensor.getThreshold2()) || (temp < _sensor.getThreshold1())) {
                simpleMailMessage.setTo(_userModel.getEmail());
                simpleMailMessage.setFrom("sensor@project.com");
                String text = "Your Sensor recorded an Anomaly in Temperature.\n\nSensor ID:" + _sensor.getId() + "\nSensor Name: " + _sensor.getName() + "\nSensor Temperature: " + temp + "C" + "\nTime: " + timeStamp;


                if (temp > _sensor.getThreshold2()) {
                    simpleMailMessage.setSubject(_sensor.getName() + ": High Temperature Warning");
                    simpleMailMessage.setText(text);
                    emailTable.setMessage(text);
                    System.out.println("Too hot");
                }

                if (temp < _sensor.getThreshold1()) {
                    simpleMailMessage.setSubject(_sensor.getName() + ": Low Temperature Warning");
                    simpleMailMessage.setText(text);
                    emailTable.setMessage(text);
                    System.out.println("Too Cold");
                }
                emailTable.setValue(temp);
                emailsentRepo.save(emailTable);
                mailSender.send(simpleMailMessage);
                _sensor.setTemps(temp, timeStamp, emailTable.getId());
            } else {
                _sensor.setTemps(temp, timeStamp, "null");
            }

            _sensor.setLastUpdate(timeStamp);
            sensorRepo.save(_sensor);
            return "Data added";
        } catch (Exception e) {
            return "No sensor detected. Exception: " + e;
        }

    }

    @PatchMapping("/{user}/update/all/{id}")
    public String updateSen2(@PathVariable String id, @RequestBody Sensor sensor, @PathVariable String user) {
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
        } catch (Exception e) {
            return e.toString();
        }
    }


}
