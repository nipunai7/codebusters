package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class UserModel {

    @Id
    private String id;
    private String username;
    private String jdate;
    private String email;
    private String password;
    private List sensors = new ArrayList();

    public UserModel() {
    }

    public UserModel(String username, String jdate, List sensors, String email, String password) {
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
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
}
