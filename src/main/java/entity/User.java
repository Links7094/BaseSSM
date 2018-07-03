package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String account;
    private String password;
    private String salt;
    private short age;
    private int companyId;
    private Date createTime;
    private Boolean isDeleted;

    private Company company;
}