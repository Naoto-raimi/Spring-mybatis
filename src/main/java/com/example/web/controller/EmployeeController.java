package com.example.web.controller;

import com.example.persistence.entity.Employee;
import com.example.service.EmployeeService;
import com.example.web.form.EmployeeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList",employeeList);
        return "employee/index";
    }

    @GetMapping("/findByNameLike")
    public String result(@RequestParam String keyword, Model model){
        List<Employee> employeeList = employeeService.findByNameLike(keyword);
        model.addAttribute("employeeList",employeeList);
        return "employee/index";
    }

    @GetMapping("/insertMain")
    public String insertMain(Model model){
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee/insertMain";
    }

    @PostMapping("/insertComplete")
    public String insertComplete(@Validated EmployeeForm employeeForm,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "employee/insertMain";
        }
        Employee employee = employeeForm.convertToEntity();
        employeeService.insert(employee);
        return "redirect:index";
    }

}
