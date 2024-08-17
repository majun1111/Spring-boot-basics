package com.mallikarjun.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(schema = "tbl_dpartment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id") if field name and the variable name is same in database then we don't need the column annotation
    private Long id;

    //@Column(name = "name")
    @NotBlank(message = "Name must not be null")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;


    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
