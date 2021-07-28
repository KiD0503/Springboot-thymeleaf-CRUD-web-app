package com.springboot.springbootthymeleafcrudwebapp.Controller;

import com.springboot.springbootthymeleafcrudwebapp.Entity.Employee;
import com.springboot.springbootthymeleafcrudwebapp.Service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage (Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "Index";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "New_Employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployees(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")long id, Model model){
        Employee employee = employeeService.getEmployeebyId(id);
        model.addAttribute("employee", employee);
        return "Update_Employee";
    }
    @GetMapping("/deleteEmployeeById/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id, Model model){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
    @GetMapping("/backToEmployee")
    public String backToEmployee(Model model){
        return "redirect:/";
    }
}
