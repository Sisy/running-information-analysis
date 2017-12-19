package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "USER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String address;

//    @OneToMany(mappedBy = "userInfo")
//    private List<RunningInformation> runningInformations = new ArrayList<>();

    public UserInfo() {
        this.username = "";
        this.address = "";
    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }

}