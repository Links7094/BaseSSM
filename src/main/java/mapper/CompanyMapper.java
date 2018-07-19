package mapper;

import entity.Company;
import entity.CompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CompanyMapper extends Mapper<Company> {
    int countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    List<Company> selectByExample(CompanyExample example);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);
}