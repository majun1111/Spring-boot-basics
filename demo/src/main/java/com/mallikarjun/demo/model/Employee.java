package com.mallikarjun.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.mallikarjun.demo.request.EmployeeRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;


@Entity
@Table(schema = "tbl_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id") if field name and the variable name is same in database then we don't need the column annotation
    private Long id;

    //@Column(name = "name")
    @NotBlank(message = "Name must not be null")
    private String name;

    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

    public Employee(EmployeeRequest request){
        this.name= request.getName();
    }

    // @Column(name = "department")
//    @NotBlank(message = "Department must not be null")
//    private String department;
//
//    //@Column(name = "location")
//    private String location;
//
//    //@Column(name = "email")
//    @Email(message = "Please enter a vaild email address")
//    private String email;
//
//    //@Column(name = "age")
//    private Long age = 0L;
//
//    @CreationTimestamp
//    @Column(name = "created_at",nullable = false,updatable = false)
//    private Date createAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Date updatedAt;

    public void setId(Long id) {
        this.id=id;

    }

    public Long getId() {
        return id;
    }
}
