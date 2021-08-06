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
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue
    private Long idService;

    private String nameService;
    private String serviceCode;
    private Double area;
    private Integer numberOfFloors;
    private Integer maxPeople;
    private Double costService;

    @ManyToOne
    @JoinColumn(name = "id_type_service",referencedColumnName = "id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "id_rent_type_service",referencedColumnName = "id")
    private RentTypeService rentTypeService;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;
}
