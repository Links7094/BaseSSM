package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Company {
    private int id;
    private String name;
    private String address;
    private Date createTime;
    private Boolean isDeleted;

}
