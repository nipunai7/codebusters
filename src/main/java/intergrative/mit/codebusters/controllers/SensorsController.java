package intergrative.mit.codebusters.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import intergrative.mit.codebusters.model.SequenceGeneratorService;
import intergrative.mit.codebusters.model.Sensors;
import intergrative.mit.codebusters.repositories.SensorsRepository;

import java.util.List;

@RestController
public class SensorsController {
    @Autowired
    public SensorsRepository sensorsRepository;
    @Autowired
    public SequenceGeneratorService sequenceGeneratorService;

    @GetMapping(value = "/all")
    public List<Sensors> getAllSensors(){
        return sensorsRepository.findAll();
    }



    @PostMapping("/update")
    public String saveUser(@RequestBody Sensors sensor) {

        //set Id
        sensor.setId(sequenceGeneratorService.generateSequence(Sensors.SEQUENCE_NAME));
        Sensors insertedSensor = sensorsRepository.insert(sensor);
        return "Data Updated ";

    }
}
