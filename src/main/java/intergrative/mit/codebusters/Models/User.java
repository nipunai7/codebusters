package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;


import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    public String id;
    public String uName;
    public String jdate;
    public String email;
    public String password;
    public List sensors = new ArrayList();

    public User() {

    }

    public User(String uName, String jdate, List sensors, String email, String password) {
        this.uName = uName;
        this.jdate = jdate;
        this.sensors = sensors;
        this.email = email;
        this.password = password;
    }

    public List getSensors() {
        return sensors;
    }

    public void setSensors(String sensorID, String timeStamp) {
        this.sensors.add(new String[]{sensorID, timeStamp});
    }


    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", uName='" + uName + '\'' +
                ", jdate='" + jdate + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sensors=" + sensors +
                '}';
    }
}
