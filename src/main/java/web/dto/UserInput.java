package web.dto;

import entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserInput implements Converter<User> {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不小于1")
    private int id;
//    @NotBlank(message = "名字不能为空字符串")
//    private String name;
//    private short age;
//    @NotNull(message = "性别不合法")
//    private Sex sex;
//    @Valid()
//    private CompanyInput company;

    @Override
    public User convert() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
//        if (this.company != null) {
////            user.setCompany(this.company.convert());
//        }
        return user;
    }
}
