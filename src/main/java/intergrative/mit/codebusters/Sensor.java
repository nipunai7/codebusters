package intergrative.mit.codebusters;

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

    public Sensor(){

    }

    public Sensor(String id, String name, Date addDate, Date lastUpdate, List temps) {
        this.id = id;
        this.name = name;
        this.addDate = addDate;
        this.lastUpdate = lastUpdate;
        this.temps = temps;

    }

    public List getTemps() {
        return temps;
    }

    public void setTemps(double d) {
        this.temps.add(d);
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

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addDate='" + addDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", temps='" + temps + '\'' +
                '}';
    }
}