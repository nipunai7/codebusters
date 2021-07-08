package intergrative.mit.codebusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CodebustersApplication implements CommandLineRunner {

	@Autowired
	private SensorRepo sensorRepo;

	public static void main(String[] args) {
		SpringApplication.run(CodebustersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sensor s1 = new Sensor("1", "Temp1", "2021.07.05", "2021.07.07");
		Sensor s2 = new Sensor("2", "Temp2", "2021.07.25", "2021.07.27");

		sensorRepo.save(s1);
		sensorRepo.save(s2);

		List<Sensor> sensors = sensorRepo.findAll();

		for (Sensor s : sensors){
			System.out.println(s.toString());
		}

	}

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
		return "Sensor Deleted"+id;
	}

}
