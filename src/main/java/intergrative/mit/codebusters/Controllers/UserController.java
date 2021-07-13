package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Models.EmailTable;
import intergrative.mit.codebusters.Models.UserModel;
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

//    @PostMapping("/addUser")
//    public String saveUser(@RequestBody UserModel user) {
//        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
//
//        List<UserModel> userData = userRepo.findAll();
//        for (UserModel user1 : userData){
//            if (user1.getEmail().equals(user.getEmail())){
//                return "UserModel Exists";
//            }
//        }
//        user.setJdate(timeStamp);
//        userRepo.save(user);
//        return "UserModel Saved: " + user.getUserId();
//    }

    @GetMapping("/listusers")
    public List<UserModel> listUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/listusers/{id}")
    public Optional<UserModel> listUsers(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @PatchMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, @RequestBody UserModel userModel) {
        System.out.println(id);
        Optional<UserModel> userData = userRepo.findById(id);
        System.out.println(userData);
        try {
            UserModel _userModel = userData.get();
            _userModel.setEmail(userModel.getEmail());
            _userModel.setUsername(userModel.getUsername());
            _userModel.setPassword(userModel.getPassword());
            userRepo.save(_userModel);
            return "UserModel Updated: " + _userModel.getUserId();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserModel userModel){
        List<UserModel> userModelData = userRepo.findAll();

        for (UserModel userModel1 : userModelData){
            if (userModel1.getEmail().equals(userModel.getEmail())){
                if (userModel1.getPassword().equals(userModel.getPassword())){

                    return "Login Success";
                }
                return "Wrong Password";
            }
            return "Wrong Credentials";
        }
        return "No userModel in Database";
    }

    @GetMapping("/emailtable")
    public List emailTable(){
        List<EmailTable> emailTables = emailsentRepo.findAll();
        return emailTables;
    }

}
