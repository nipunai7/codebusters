package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.utils.AuthResponse;
import intergrative.mit.codebusters.Models.Login;
import intergrative.mit.codebusters.Models.UserModel;
import intergrative.mit.codebusters.Repositories.UserRepo;
import intergrative.mit.codebusters.utils.JwtUtil;
import intergrative.mit.codebusters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/")

public class AuthController {

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth/register")
    private ResponseEntity<?> register(@RequestBody UserModel userModel) {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());

        List<UserModel> userModelData = userRepo.findAll();
        for (UserModel userModel1 : userModelData) {
            if (userModel1.getEmail().equals(userModel.getEmail())) {
                return ResponseEntity.ok(new AuthResponse("Email is already in the System"));
            }
        }
        userModel.setJdate(timeStamp);
        try {
            userRepo.save(userModel);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.ok(new AuthResponse("Error occurred" + e));
        }
        final UserDetails userDetails = userService.loadUserByUsername(userModel.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails,userModel.getUserId(),userModel.getUsername());
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/auth/login")
    private ResponseEntity<?> login(@RequestBody Login login) {

        String user = login.getEmail();
        String pass = login.getPass();

        System.out.println(user + pass);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, pass));
            System.out.println("Login Complete");
        } catch (BadCredentialsException e) {
            System.out.println("Error: "+ e);
            return ResponseEntity.ok(new AuthResponse("Error: "+ e));
        }

        final UserDetails userDetails = userService.loadUserByUsername(user);
        UserModel userModel = userRepo.findByEmail(user);
        final String jwt = jwtUtil.generateToken(userDetails,userModel.getUserId(),userModel.getUsername());
        return ResponseEntity.ok(new AuthResponse(jwt));
    }

}
