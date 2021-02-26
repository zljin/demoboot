package cn.zoulj.mapper;


import cn.zoulj.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

//无配置版本
public interface EmployeeMapper {

    @Select("SELECT * FROM employee where id = #{sn}")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "departmentSn",column = "department_sn"),
            @Result(property = "post",column = "post"),
            @Result(property = "password",column = "password"),
            @Result(property = "sn",column = "sn")
    })
    Employee selectOne(String sn);


    @Insert("insert into employee(sn,password,name,department_sn,post) " +
            "values (#{sn},#{password},#{name},#{departmentSn},#{post}) ")
    void insert(Employee employee);
}
