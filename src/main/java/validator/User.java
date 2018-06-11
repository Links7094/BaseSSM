package validator;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class User {
    @NotBlank(message = "名字不能为空字符串")
    private String name;
    private int age;
    @NotNull(message = "企业不能为空")
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
