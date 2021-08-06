package com.codegym.dto;

import com.codegym.model.entity.RentTypeService;
import com.codegym.model.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private Long idService;
    @NotBlank(message = "Not be empty!")
    private String nameService;
    @Pattern(regexp = "^(DV)-[0-9]{4}$",
            message = "Must be in the right format DV-XXXX (X is 0-9)")
    private String serviceCode;
    @Min(value = 0,message = "Please enter a positive number ")
    private Double area;
    @Min(value = 0,message = "Please enter a positive number ")
    private Integer numberOfFloors;
    @Min(value = 0,message = "Please enter a positive number ")
    private Integer maxPeople;
    private Double costService;
    private ServiceType serviceType;
    private RentTypeService rentTypeService;
}
