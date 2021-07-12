package intergrative.mit.codebusters.Repositories;

import intergrative.mit.codebusters.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
