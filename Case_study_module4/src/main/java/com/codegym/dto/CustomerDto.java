package com.codegym.dto;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long idCustomer;
    @NotBlank(message = "Not be empty!")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Must be in the right format KH-xxxx")
    private String customerCode;
    private CustomerType customerType;
    @NotBlank(message = "Not be empty!")
    private String nameCustomer;
    @NotNull(message = "Not be empty")
    private String dateOfBirthCustomer;
    @Pattern(regexp = "^\\d{9}|\\d{12}$",message = "9 or 12 Number")
    private String cardCustomer;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",
            message = " 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String phoneNumberCustomer;
    @Email(message = "Must be in the right format 'abc@gmail.com'")
    private String emailCustomer;
    @NotBlank(message = "Not be empty!")
    private String addressCustomer;
}
