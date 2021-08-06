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
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomerType;
    private String typeNameCustomer;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;
}
