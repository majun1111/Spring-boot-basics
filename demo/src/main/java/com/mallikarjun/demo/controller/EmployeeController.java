package com.mallikarjun.demo.controller;

import com.mallikarjun.demo.model.Department;
import com.mallikarjun.demo.model.Employee;
import com.mallikarjun.demo.repository.DepartmentRepository;
import com.mallikarjun.demo.repository.EmployeeRepository;
import com.mallikarjun.demo.request.EmployeeRequest;
import com.mallikarjun.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity <List<Employee>>displayEmployees(@RequestParam int pageNumber, @RequestParam int pageSize){
        return new ResponseEntity<List<Employee>> (employeeService.getAllEmployees(pageNumber, pageSize),HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        Employee employee = new Employee(employeeRequest);
        employeeRepository.save(employee);

        for (String s : employeeRequest.getDepartment()) {
            Department department = new Department();
            department.setName(s);
            department.setEmployee(employee);

            departmentRepository.save(department);
        }
        return new ResponseEntity<String>("Record saved successfully",HttpStatus.CREATED);
    }


//    @PostMapping("/employees") Used for One to one relationship
//    public ResponseEntity <Employee> createEmployee(@Valid @RequestBody EmployeeRequest eRequest){
//        Department department = new Department();
//        department.setName(eRequest.getDepartment());
//
//        department = departmentRepository.save(department);
//
//        Employee employee = new Employee(eRequest);
//        employee.setDepartment(department);
//
//        employeeRepository.save(employee);
//
//        return  new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
//    }

    @GetMapping("/employees/{id}")
    public Employee displayEmployeeForId(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees")
    public Employee updateEmployee( @RequestParam Long id, @RequestBody Employee employee ){
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

//    @GetMapping("/employees/filter/{name}")
//    public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable String name){
//        //return new ResponseEntity<List<Employee>>(employeeRepository.findByDepartmentName(name), HttpStatus.OK);
//        return new ResponseEntity<List<Employee>>(employeeRepository.getEmployeesByDepartmentName(name),HttpStatus.OK);
//    }
//    @GetMapping("/employees/filterByName")
//    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name),HttpStatus.OK);
//    }

//    @GetMapping("/employees/filterByNameAndLocation")
//    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,@RequestParam String location){
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
//    }
//
//    @GetMapping("employees/filterByNameContaining")
//    public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@RequestParam String keyword){
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameContaining(keyword),HttpStatus.OK);
//    }
//
//    @GetMapping("/employees/{name}/{location}")
//    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable  String name,@PathVariable String location){
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocation(name,location),HttpStatus.OK);
//    }
//
//    @DeleteMapping("/employees/delete/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public String deleteEmployeeByName(@PathVariable String name){
//        return "Number of Records that are deleted : "+employeeService.deleteEmployeeByName(name);
//    }

}
