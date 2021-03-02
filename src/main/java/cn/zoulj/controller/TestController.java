package cn.zoulj.controller;

import cn.zoulj.pojo.Employee;
import cn.zoulj.service.EmployeeService;
import cn.zoulj.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RedisOperator redisOperator;

    @GetMapping("/mybatis")
    public Employee test(){
        //查找
        Employee employee = employeeService.get("10001");
        //修改
        employee.setName("科比111");
        employeeService.edit(employee);
        //增加
        /*employee.setName("科比222");
        employee.setSn("9999");
        employeeService.add(employee);*/
        //todo 之后删除
        //todo employeeService.remove("9999");

        //查询
        List<Employee> employeeList = employeeService.selectByPost("员工");
        employeeList.stream().forEach(e-> System.out.println(e.getName()));
        return employee;
    }

    @GetMapping("/redis")
    public String test2(){
        Employee employee = employeeService.get("10001");
        redisOperator.set("loginSession",employee.toString(),30);
        //redis具体的操作都在此工具类中
        //以前写过基于redission的分布式锁，本质就是setnx这个命令
        //基于redis做登录后的购物车，和cookie结合
        System.out.println(redisOperator.get("loginSession"));
        return "ok";
    }
}
