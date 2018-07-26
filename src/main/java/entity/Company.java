package entity;

import java.util.Date;
import lombok.*;

@Data
public class Company {
    /**
     *
     * 企业id，主键
     */
    private Integer id;

    /**
     *
     * 企业名称，唯一
     */
    private String name;

    /**
     *
     * 企业地址
     */
    private String address;

    /**
     *
     * 
     */
    private Date createTime;

    /**
     *
     * 
     */
    private Boolean isDeleted;
}