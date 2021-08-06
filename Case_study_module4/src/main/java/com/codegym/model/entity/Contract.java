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
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContract;

    private String dateBegin;
    private String dateEnd;
    private Double deposit;
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "id_employee",referencedColumnName = "idEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_service",referencedColumnName = "idService")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

}
