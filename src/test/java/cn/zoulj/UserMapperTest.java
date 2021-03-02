package cn.zoulj;


import cn.zoulj.dao.EmployeeMapper;
import cn.zoulj.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testQuery(){
        System.out.println(employeeMapper);
        List<Employee> employees = employeeMapper.getAll();
        employees.stream().forEach(s-> System.out.println(s));
    }
}
