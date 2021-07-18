package com.codegym.controller;

import com.codegym.model.bean.Student;
import com.codegym.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping(value = "/student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(value = {"", "/list"})
    public ModelAndView goListStudent(@RequestParam(required = false) String msgAdd,
                                      Model model) {
        ModelAndView modelAndView = new ModelAndView("list_student");
        modelAndView.addObject("listStudent", this.studentService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String goCreate() {
        return "create_student";
    }

    @PostMapping(value = "/create")
    public String createNewStudent(@RequestParam String nameStudent, @RequestParam String dateOfBirth,
                                   RedirectAttributes redirectAttributes) {
        Student student = new Student(nameStudent, dateOfBirth);
        this.studentService.save(student);

        redirectAttributes.addAttribute("msgAdd", "test");
        redirectAttributes.addFlashAttribute("msg","Create new successfully!");

        return "redirect:/student/list";
    }

    @GetMapping("/detail")
    public String goDetailRP(@RequestParam Integer idStudent, Model model) {
        model.addAttribute("studentDetail",
                this.studentService.findById(idStudent));

        return "detail_student";
    }

    @GetMapping("/detail/{idStudent}")
    public String goDetailPV(@PathVariable Integer idStudent, Model model) {
        model.addAttribute("studentDetail",
                this.studentService.findById(idStudent));

        return "detail_student";
    }
}
