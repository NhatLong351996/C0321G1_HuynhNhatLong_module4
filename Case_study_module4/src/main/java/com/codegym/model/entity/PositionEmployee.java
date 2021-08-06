package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPosition;
    private String namePosition;

    @OneToMany(mappedBy = "positionEmployee")
    private Set<Employee> employees;
}
