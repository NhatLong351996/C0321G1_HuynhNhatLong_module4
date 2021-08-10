package com.codegym.dto;

import com.codegym.model.entity.EducationDegree;
import com.codegym.model.entity.EmployeeDivision;
import com.codegym.model.entity.PositionEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long idEmployee;
    @NotBlank(message = "Not be empty!")
    private String nameEmployee;
    @NotNull(message = "Not be empty")
    private String dateOfBirth;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "9 or 12 Numbers")
    private String card;
    @Min(value = 0,message = "Please enter a positive number!")
    private Double salary;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",
            message = " 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank(message = "Not be empty!")
    private String addressEmployee;
    private PositionEmployee positionEmployee;
    private EducationDegree educationDegree;
    private EmployeeDivision employeeDivision;
}
