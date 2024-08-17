package com.mallikarjun.demo.service;

import com.mallikarjun.demo.model.Employee;
import com.mallikarjun.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
            Employee emp = getEmployeeById(id);
            employeeRepository.delete(emp);

    }

    @Override
    public List<Employee> getAllEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,"id");
        return employeeRepository.findAll(pages).getContent();
    }


    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        }
        throw new RuntimeException("Employee not found with id "+ id);
    }

//    @Override
//    public List<Employee> getEmployeesByName(String name) {
//        return employeeRepository.findByName(name);
//    }

//    @Override
//    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
//        return employeeRepository.findByNameAndLocation(name, location);
//    }
//
//    @Override
//    public List<Employee> getEmployeeByNameContaining(String keyword) {
//        Sort sort= Sort.by(Sort.Direction.DESC, "id");
//        return employeeRepository.findByNameContaining(keyword, sort);
//    }
//
//    @Override
//    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
//        return employeeRepository.getEmployeeByNameAndLocation(name, location);
//    }
//
//    @Override
//    public Integer deleteEmployeeByName(String name) {
//        return employeeRepository.deleteEmployeeByName(name);
//    }
}
