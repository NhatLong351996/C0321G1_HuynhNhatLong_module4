package com.codegym.dto;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import com.codegym.model.entity.Service;
import com.codegym.model.service.contract_detail_service.IContractDetailService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ContractDto {
    private Long idContract;
    @NotBlank(message = "Not be empty!")
    private String dateBegin;
    @NotBlank(message = "Not be empty!")
    private String dateEnd;
    @Min(value = 0,message = "You have not enter the deposit!")
    @NotNull(message = "Not be empty!")
    private Double deposit;
    private Double totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;
}
