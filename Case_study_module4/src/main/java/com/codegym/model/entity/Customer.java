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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    @ManyToOne
    @JoinColumn(name = "id_type_customer", referencedColumnName = "idCustomerType")
    private CustomerType customerType;
    private String customerCode;
    private String nameCustomer;
    private String dateOfBirthCustomer;
    private String cardCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String addressCustomer;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

}
