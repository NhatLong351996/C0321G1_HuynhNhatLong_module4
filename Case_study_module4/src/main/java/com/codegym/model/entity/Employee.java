package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployee;
    private String nameEmployee;
    private String dateOfBirth;
    private String card;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String addressEmployee;

    @ManyToOne
    @JoinColumn(name = "id_position",referencedColumnName = "idPosition")
    private PositionEmployee positionEmployee;

    @ManyToOne
    @JoinColumn(name = "id_education_degree",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "id_division",referencedColumnName = "id")
    private EmployeeDivision employeeDivision;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;
}
