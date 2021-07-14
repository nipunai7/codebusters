package intergrative.mit.codebusters.Repositories;

import intergrative.mit.codebusters.Models.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SensorRepo extends MongoRepository<Sensor, String> {

    List<Sensor> findByUserID(String userid);
}
