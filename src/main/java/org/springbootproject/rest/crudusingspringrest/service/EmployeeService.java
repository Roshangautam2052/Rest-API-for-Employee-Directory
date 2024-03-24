package org.springbootproject.rest.crudusingspringrest.service;

import org.springbootproject.rest.crudusingspringrest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployeeList();
    Employee addEmployee(Employee employee);
    Employee findEmployeeById(int id);
    void deleteEmployee(int id);

}
