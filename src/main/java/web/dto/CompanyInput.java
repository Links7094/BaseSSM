package web.dto;

import entity.Company;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@ToString
public class CompanyInput implements Converter<Company>{

    private int id;
    @NotBlank(message = "company.name can't be blank")
    private String name;

    @Override
    public Company convert() {
        Company company = new Company();
        BeanUtils.copyProperties(this, company);
        return company;
    }
}
