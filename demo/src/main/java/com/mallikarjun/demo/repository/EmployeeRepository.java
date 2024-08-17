package com.mallikarjun.demo.repository;

import com.mallikarjun.demo.model.Employee;
import jakarta.persistence.Entity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    // Where Operator
//    List<Employee> findByName(String name);
//
//    // AND Operator
//    List<Employee> findByNameAndLocation(String name, String Location);
//
//    //LIke operator
//    List<Employee> findByNameContaining(String keyword, Sort sort);
//
//    @Query("FROM Employee WHERE name = :name OR location = :location")
//    List<Employee> getEmployeeByNameAndLocation(String name, String location);
//
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Employee WHERE name = :name")
//    Integer deleteEmployeeByName(String name);

//    List<Employee> findByDepartmentName(String name);
//
//    @Query("FROM Employee WHERE department.name =:name")
//    List<Employee> getEmployeesByDepartmentName(String name);

}
