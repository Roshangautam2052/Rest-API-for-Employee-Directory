package org.springbootproject.rest.crudusingspringrest.rest;

import org.springbootproject.rest.crudusingspringrest.entity.Employee;
import org.springbootproject.rest.crudusingspringrest.entity.ResponseMessage;
import org.springbootproject.rest.crudusingspringrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    // Use constructor injection to inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }
    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findEmployeeList();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found"+ employeeId);
        }
        return employee;
    }

    // add mapping for POST employee

    @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // to achieve the save operation we force the id to be 0 if id is passed in JSON
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.addEmployee(theEmployee);
        return dbEmployee;
    }

    // add mapping for Put/employees -update existing employees

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee updatingEmployee){
        if(updatingEmployee.getId()<0){
            throw new RuntimeException("Id cannot be zero" + updatingEmployee.getId());
        }
        // to achieve the updating method the id field is not zero
        Employee employee = employeeService.addEmployee(updatingEmployee);
        return employee;

    }
    // add mapping for Delete /employees/{employeeId} -delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable  int employeeId ){
        Employee employee = employeeService.findEmployeeById(employeeId);
        if(employee ==null){
            throw new RuntimeException("Employee of " + employeeId + "doesn't exists");
        }
        employeeService.deleteEmployee(employeeId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage( employeeId+ " entry" + " Deleted Successfully");
        return responseMessage.getMessage();
    }


}
