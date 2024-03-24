# Create REST API with Spring Boot-for-Employee-Directory
Demo application to create RestAPI using **Spring Boot** where Client consumes endpoints to perform CRUD operations on a database.  
## Rest client are able to:
* Get a list of employees
* Add a new employee
* Update an employee
* Delete an employee
* Find employee by id
## Application Architecture:
* The client sends HTTP requests to EmployeeRestController to perform CRUD operations in MySQL database.
* EmployeeService layer is in between EmployeeRestController and EmployeeDAO where Stanadard JPA API is used as EmployeeDAO which connects to MySQL database.
## Dependencies Used:
1. Spring Web
2. MySQL connector 
3. Lombook
4. Spring Data JPA
5. Spring Boot DevTools
