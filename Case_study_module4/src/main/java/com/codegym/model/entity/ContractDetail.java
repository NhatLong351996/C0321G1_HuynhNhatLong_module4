package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_contract",referencedColumnName = "idContract")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "id_attach_service",referencedColumnName = "id")
    private AttachService attachService;
}
