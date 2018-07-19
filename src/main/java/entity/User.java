package entity;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@Table(name = "tb_user")
public class User {
    /**
     * 用户id，主键
     */
    private Integer id;

    /**
     * 账号，唯一
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 性别， 1：男 2：女 3：其他
     */
    private Byte sex;

    /**
     * 外键关联企业表
     */
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}