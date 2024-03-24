package org.springbootproject.rest.crudusingspringrest.service;

import org.springbootproject.rest.crudusingspringrest.dao.EmployeeDao;
import org.springbootproject.rest.crudusingspringrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findEmployeeList() {
        return employeeDao.findEmployeeList();
    }
    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }
    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
