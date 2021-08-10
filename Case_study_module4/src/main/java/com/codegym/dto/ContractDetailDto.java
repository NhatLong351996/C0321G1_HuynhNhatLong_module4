package com.codegym.dto;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetailDto {
    private Long id;
    @Min(value = 0,message = "Please choose quantity > 0")
    @NotNull(message = "Not be empty!")
    private Integer quantity;
    private Contract contract;
    private AttachService attachService;
}
