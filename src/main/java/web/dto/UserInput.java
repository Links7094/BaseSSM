package web.dto;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;

@Getter
@Setter
@ToString
public class UserInput implements Converter<User>{
    @NotBlank(message = "名字不能为空字符串")
    private String name;
    private int age;
    @Valid()
    private CompanyInput company;

    @Override
    public User convert() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        if (this.company != null){
            user.setCompany(this.company.convert());
        }
        return user;
    }
}
