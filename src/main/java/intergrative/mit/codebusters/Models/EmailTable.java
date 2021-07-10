package intergrative.mit.codebusters.Models;

import org.springframework.data.annotation.Id;

public class EmailTable {

    @Id
    public String id;
    public String time;
    public String userId;
    public String sensorId;
    public String message;
    public String to;
    public String from;

    public double value;

    public EmailTable() {

    }

    public EmailTable(String time, String userId, String sensorId, String message, String to, String from, double value) {
        this.time = time;
        this.userId = userId;
        this.sensorId = sensorId;
        this.message = message;
        this.to = to;
        this.from = from;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
