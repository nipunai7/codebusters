package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    @Id
    private String id;
    private String type;
    private String name;
    private String addDate;
    private String lastUpdate;
    private List temps = new ArrayList();
    private String userID;
    private double threshold1;
    private double threshold2;

    public Sensor() {
    }

    public Sensor(String name, String addDate, String lastUpdate, List temps, String userID, double threshold1, double threshold2, String type) {
        this.name = name;
        this.addDate = addDate;
        this.lastUpdate = lastUpdate;
        this.temps = temps;
        this.userID = userID;
        this.threshold1 = threshold1;
        this.threshold2 = threshold2;
        this.type = type;
    }

    public List getTemps() {
        return temps;
    }

    public void setTemps(double d, String stamp, String emialId) {
        this.temps.add(new String[]{String.valueOf(d), stamp, emialId});
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getThreshold1() {
        return threshold1;
    }

    public void setThreshold1(double threshold1) {
        this.threshold1 = threshold1;
    }

    public double getThreshold2() {
        return threshold2;
    }

    public void setThreshold2(double threshold2) {
        this.threshold2 = threshold2;
    }

    public String getType() {
        return type;
    }

    public String setType(String type) {
        this.type = type;
        return type;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addDate='" + addDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", temps='" + temps + '\'' +
                ", UserId='" + userID + '\'' +
                ", threshold1='" + threshold1 + '\'' +
                ", threshold2='" + threshold2 + '\'' +
                '}';
    }
}