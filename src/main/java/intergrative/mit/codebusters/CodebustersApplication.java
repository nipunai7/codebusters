package intergrative.mit.codebusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CodebustersApplication{

	@Autowired
	private SensorRepo sensorRepo;

	public static void main(String[] args) {
		SpringApplication.run(CodebustersApplication.class, args);
	}



}
