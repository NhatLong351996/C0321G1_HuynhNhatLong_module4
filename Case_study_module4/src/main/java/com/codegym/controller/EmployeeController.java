package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.*;
import com.codegym.model.service.employee_service.EmployeeDivisionService;
import com.codegym.model.service.employee_service.EmployeeService;
import com.codegym.model.service.employee_service.IEmployeeEducationService;
import com.codegym.model.service.employee_service.IEmployeePositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDivisionService employeeDivisionService;
    @Autowired
    private IEmployeeEducationService iEmployeeEducationService;
    @Autowired
    private IEmployeePositionService iEmployeePositionService;
    @ModelAttribute("listDivision")
    public List<EmployeeDivision> getListDivision(){
        return employeeDivisionService.findAll();
    }
    @ModelAttribute("listEdu")
    public List<EducationDegree> getListEducation(){
        return iEmployeeEducationService.findAll();
    }
    @ModelAttribute("listPosition")
    public List<PositionEmployee> getListPositionEmployee(){
        return iEmployeePositionService.findAll();
    }
    @GetMapping
    public ModelAndView getFormListEmployee(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Page<Employee> employees;
        if (search.isPresent()) {
            employees = employeeService.findByNameEmployeeContaining(search.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("search", search.orElse(null));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView getFormCreate() {
        return new ModelAndView("/employee/create",
                "employeeDto", new EmployeeDto());
    }
    @PostMapping("/create")
    public ModelAndView createEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                                       BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("employeeDto", employeeDto);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            modelAndView.addObject("employeeDto", new EmployeeDto());
            modelAndView.addObject("message",
                    employee.getNameEmployee() + " create success!");
        }
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return new ModelAndView("employee/edit", "employeeDto", employeeDto);
    }

    @PostMapping("/edit")
    public ModelAndView update(@Valid @ModelAttribute EmployeeDto employeeDto,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("employeeDto", employeeDto);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            modelAndView.addObject("employeeDto", employeeDto);
            modelAndView.addObject("message",
                    employeeDto.getNameEmployee() + " update success!");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id,
                               RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        redirectAttributes.addFlashAttribute("message", employee.getNameEmployee() + " delete success!");
        return new ModelAndView("redirect:/employee");
    }

    @GetMapping("/view/{id}")
    public ModelAndView getView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("employee/view");
        Employee employee = employeeService.findById(id);
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "INFORMATION OF " +
                employee.getNameEmployee());
        return modelAndView;

    }
}
