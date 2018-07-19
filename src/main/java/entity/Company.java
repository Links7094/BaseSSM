package entity;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@Table(name = "tb_company")
public class Company {
    /**
     * 企业id，主键
     */
    private Integer id;

    /**
     * 企业名称，唯一
     */
    private String name;

    /**
     * 企业地址
     */
    private String address;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}