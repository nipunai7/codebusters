package intergrative.mit.codebusters;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepo extends MongoRepository<Sensor, String> {
}
