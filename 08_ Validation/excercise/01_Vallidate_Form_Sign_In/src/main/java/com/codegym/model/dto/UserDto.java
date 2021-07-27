package com.codegym.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @Email(message = "Invalid email")
    private String email;
    private String phoneNumber;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        if (userDto.getFirstName().length()<5 || userDto.getFirstName().length()>45){
            errors.rejectValue("firstName","firstName.length");
        }
        ValidationUtils.rejectIfEmpty(errors,"lastName","lastName.empty");
        if (userDto.getLastName().length()<5 || userDto.getLastName().length()>45){
            errors.rejectValue("lastName","lastName.length");
        }
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (userDto.getPhoneNumber().length()>11 || userDto.getPhoneNumber().length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!userDto.getPhoneNumber().startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!userDto.getPhoneNumber().matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (userDto.getAge()<18){
            errors.rejectValue("age", "age.min");
        }
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");



    }
}
