package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sensor {

    @Id
    public String id;
    public String name;
    public Date addDate;
    public Date lastUpdate;
    public List temps = new ArrayList();
    public int userID;
    public double threshold1;
    public double threshold2;

    public Sensor() {
    }

    public Sensor(String name, Date addDate, Date lastUpdate, List temps, int userID, double threshold1, double threshold2) {
        this.name = name;
        this.addDate = addDate;
        this.lastUpdate = lastUpdate;
        this.temps = temps;
        this.userID = userID;
        this.threshold1 = threshold1;
        this.threshold2 = threshold2;
    }

    public List getTemps() {
        return temps;
    }

    public void setTemps(double d,Date stamp) {
        this.temps.add(new String[]{String.valueOf(d), String.valueOf(stamp)});
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) {this.userID = userID; }

    public double getThreshold1() { return threshold1; }

    public void setThreshold1(double threshold1) {this.threshold1 = threshold1;}

    public double getThreshold2() {return threshold2;}

    public void setThreshold2(double threshold2) {this.threshold2 = threshold2;}

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