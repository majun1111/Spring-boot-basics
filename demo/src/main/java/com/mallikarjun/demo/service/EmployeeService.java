package com.mallikarjun.demo.service;

import com.mallikarjun.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;


public interface EmployeeService {

    Employee saveEmployeeDetails(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployees(int pageNumber, int pageSize);

    Employee getEmployeeById(Long id);

//    List<Employee> getEmployeesByName(String name);

//    List<Employee> getEmployeesByNameAndLocation(String name,String Location);
//
//    List<Employee> getEmployeeByNameContaining(String keyword);
//
//    List <Employee> getEmployeesByNameOrLocation(String name, String location);

//    Integer deleteEmployeeByName(String name);}
}