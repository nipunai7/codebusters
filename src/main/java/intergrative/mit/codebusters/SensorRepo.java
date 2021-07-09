package intergrative.mit.codebusters;

import intergrative.mit.codebusters.Models.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepo extends MongoRepository<Sensor, String> {
}
