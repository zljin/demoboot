package cn.zoulj.service.impl;

import cn.zoulj.dao.EmployeeDao;
import cn.zoulj.pojo.Employee;
import cn.zoulj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional//事务传播回滚
    @Override
    public void add(Employee employee) {
        employeeDao.insert(employee);
    }

    @Transactional
    @Override
    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional
    @Override
    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    @Override
    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    @Override
    public List<Employee> selectByPost(String post) {
        return employeeDao.selectByPost(post);
    }
}
