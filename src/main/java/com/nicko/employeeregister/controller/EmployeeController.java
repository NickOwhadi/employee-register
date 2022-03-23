package com.nicko.employeeregister.controller;

import com.nicko.employeeregister.bootstrap.DataGenerator;
import com.nicko.employeeregister.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    public String createEmployee(Model model){

    model.addAttribute("employee", new Employee());
    model.addAttribute("states", DataGenerator.getAllStates());


        return "employee/employee-create";
    }
    @PostMapping("/list")
    public String createEmployee2(@ModelAttribute("employee") Employee employee, Model model){

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());


        return "employee/employee-list";
    }



}
