package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Models.EmailTable;
import intergrative.mit.codebusters.Models.User;
import intergrative.mit.codebusters.Repositories.EmailsentRepo;
import intergrative.mit.codebusters.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailsentRepo emailsentRepo;

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user) {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

        List<User> userData = userRepo.findAll();
        for (User user1 : userData){
            if (user1.getEmail().equals(user.getEmail())){
                return "User Exists";
            }
        }
        user.setJdate(timeStamp);
        userRepo.save(user);
        return "User Saved: " + user.getUserId();
    }

    @GetMapping("/listusers")
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/listusers/{id}")
    public Optional<User> listUsers(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @PatchMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User user) {
        System.out.println(id);
        Optional<User> userData = userRepo.findById(id);
        System.out.println(userData);
        try {
            User _user = userData.get();
            _user.setEmail(user.getEmail());
            _user.setuName(user.getuName());
            _user.setPassword(user.getPassword());
            userRepo.save(_user);
            return "User Updated: " + _user.getUserId();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody User user){
        List<User> userData = userRepo.findAll();
        for (User user1 : userData){
            if (user1.getEmail().equals(user.getEmail())){
                if (user1.getPassword().equals(user.getPassword())){
                    return "Login Success";
                }
                return "Wrong Password";
            }
            return "Wrong Credentials";
        }
        return "No user in Database";
    }

    @GetMapping("/emailtable")
    public List emailTable(){
        List<EmailTable> emailTables = emailsentRepo.findAll();
        return emailTables;
    }

}
