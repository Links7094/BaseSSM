package web.dto;

import constant.Sex;
import entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserInput implements Converter<User> {
    @NotBlank(message = "名字不能为空字符串")
    private String name;
    private short age;
    @NotNull(message = "性别不合法")
    private Sex sex;
    @Valid()
    private CompanyInput company;

    @Override
    public User convert() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        if (this.company != null) {
//            user.setCompany(this.company.convert());
        }
        return user;
    }
}
