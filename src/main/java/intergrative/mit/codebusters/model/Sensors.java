package intergrative.mit.codebusters.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;

@Document(collection = "sensors")
public class Sensors {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private long id;

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private double sensor1;
    private double sensor2;
    private double sensor3;


    public Sensors() {
        super();
    }

    public Sensors(double sensor1, double sensor2, double sensor3) {
        super();
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSensor1() {
        return sensor1;
    }

    public void setSensor1(double sensor1) {
        this.sensor1 = sensor1;
    }

    public double getSensor2() {
        return sensor2;
    }

    public void setSensor2(double sensor2) {
        this.sensor2 = sensor2;
    }

    public double getSensor3() {
        return sensor3;
    }

    public void setSensor3(double sensor3) {
        this.sensor3 = sensor3;
    }
}
