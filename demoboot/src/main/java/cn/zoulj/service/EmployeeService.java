package cn.zoulj.service;

import cn.zoulj.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);

    void edit(Employee employee);

    void remove(String sn);

    Employee get(String sn);

    List<Employee> selectByPost(String post);
}
