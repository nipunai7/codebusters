package intergrative.mit.codebusters.services;

import intergrative.mit.codebusters.Models.UserModel;
import intergrative.mit.codebusters.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel foundUserModel = userRepo.findByEmail(username);
        if (foundUserModel == null) {
            return null;
        }

        String name = foundUserModel.getEmail();
        String pwd = foundUserModel.getPassword();

        return new User(name, pwd, new ArrayList<>());
    }


}
