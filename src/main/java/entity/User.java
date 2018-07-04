package entity;

import constant.Sex;
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
    private String name;
    private short age;
    private Sex sex;
    private int companyId;
    private Date createTime;
    private Boolean isDeleted;

    private Company company;
}
