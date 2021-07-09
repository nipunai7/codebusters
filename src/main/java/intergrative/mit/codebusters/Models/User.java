package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getJdate() {
        return jdate;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public List getSensors() {
        return sensors;
    }

    public void setSensors(List sensors) {
        this.sensors = sensors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String uName, String jdate, List sensors, String email, String password) {
        this.uName = uName;
        this.jdate = jdate;
        this.sensors = sensors;
        this.email = email;
        this.password = password;
    }

    @Id
    public int UserId;
    public String uName;
    public String jdate;
    public List sensors = new ArrayList();
    public String email;
    public String password;
}
