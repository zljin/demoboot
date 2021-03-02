package cn.zoulj.dao;


import cn.zoulj.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

//无配置版本
@Component
public interface EmployeeMapper {

    @Select("SELECT * from employee")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "departmentSn",column = "department_sn"),
            @Result(property = "post",column = "post"),
            @Result(property = "password",column = "password"),
            @Result(property = "sn",column = "sn")
    })
    List<Employee> getAll();

    @Select("SELECT * FROM employee where id = #{sn}")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "departmentSn",column = "department_sn"),
            @Result(property = "post",column = "post"),
            @Result(property = "password",column = "password"),
            @Result(property = "sn",column = "sn")
    })
    Employee selectOne(@Param("sn") String sn);


    @Insert("insert into employee(sn,password,name,department_sn,post) " +
            "values (#{sn},#{password},#{name},#{departmentSn},#{post}) ")
    void insert(Employee employee);

    @Update("update employee set name=#{name},password=#{password} " +
            " department_sn=#{departmentSn},post=#{post} where sn=#{sn}")
    void update(Employee employee);

    @Delete(" delete from employee where sn=#{sn} ")
    void delete(String sn);
}
