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
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameAttachService;
    private Double costAttachService;
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;
}
