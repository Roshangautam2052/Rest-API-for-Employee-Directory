package org.springbootproject.rest.crudusingspringrest.dao;

import org.springbootproject.rest.crudusingspringrest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findEmployeeList();
    Employee addEmployee(Employee employee);
    Employee findEmployeeById(int id);
    void deleteEmployee(int id);






}

