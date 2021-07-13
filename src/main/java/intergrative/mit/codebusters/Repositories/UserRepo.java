package intergrative.mit.codebusters.Repositories;

import intergrative.mit.codebusters.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserModel, String> {

    UserModel findByEmail(String username);

}
