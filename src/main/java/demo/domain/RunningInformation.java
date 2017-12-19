package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {
    enum HealthWarningLevel {
        LOW, NORMAL, HIGH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String latitude, longtitude;

    private float runningDistance;

    private Long totalRunningTime;

    private String runningId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_id")
    private UserInfo userInfo;

    private int heartRate = 0;

    private HealthWarningLevel healthWarningLevel = HealthWarningLevel.LOW;
    private Date timestamp = new Date();

    public void setHeartRate(int heartRate) {
        this.heartRate = ThreadLocalRandom.current().nextInt(60, 201);
        if (this.heartRate >= 60 && this.heartRate <= 75) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
            return;
        } else if (this.heartRate>75 && this.heartRate <= 120) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
            return;
        }
        this.healthWarningLevel = HealthWarningLevel.HIGH;
    }
    public RunningInformation() {}

    public String getUsername() {
        return this.userInfo == null ? "" : this.userInfo.getUsername();
    }

    @JsonCreator
    public RunningInformation( @JsonProperty("username") String username, @JsonProperty("address") String address) {
        this.userInfo = new UserInfo(username, address);
    }



}
