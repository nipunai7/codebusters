package intergrative.mit.codebusters;

import org.springframework.data.annotation.Id;

public class Sensor {

    @Id
    public String id;
    public String name;
    public String addDate;
    public String lastUpdate;

    public Sensor(){

    }

    public Sensor(String id, String name, String addDate, String lastUpdate) {
        this.id = id;
        this.name = name;
        this.addDate = addDate;
        this.lastUpdate = lastUpdate;
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

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addDate='" + addDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
