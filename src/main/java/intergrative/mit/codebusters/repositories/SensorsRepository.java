package intergrative.mit.codebusters.repositories;


import intergrative.mit.codebusters.model.Sensors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorsRepository extends MongoRepository<Sensors,Long> {
}
