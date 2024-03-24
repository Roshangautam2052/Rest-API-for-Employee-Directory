package org.springbootproject.rest.crudusingspringrest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springbootproject.rest.crudusingspringrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    //define field for entity EntityManager
    private EntityManager entityManager;

    /*
    Use constructor injection for injection of entity manager here
    the entityManager is automatically created by Spring Boot
     */
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public Employee addEmployee(Employee employee){
        Employee updatedEmployee = entityManager.merge(employee);
        return updatedEmployee;
    }
    @Override
    public List<Employee> findEmployeeList(){
        // create query
        TypedQuery<Employee>getEmployeeListQuery = entityManager.createQuery("FROM Employee ", Employee.class);
        List<Employee> employeeList = getEmployeeListQuery.getResultList();
        return employeeList;
    }
    @Override
    public Employee findEmployeeById(int id){
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class , id);
        // return employee
        return theEmployee;
    }

    @Override
    public void deleteEmployee(int id){
        // find employee by id
       Employee employeeToBeRemoved = entityManager.find(Employee.class, id);
       entityManager.remove(employeeToBeRemoved);

    }

}
