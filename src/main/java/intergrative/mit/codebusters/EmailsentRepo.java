package intergrative.mit.codebusters;

import intergrative.mit.codebusters.Models.EmailTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailsentRepo extends MongoRepository<EmailTable, String> {
}
