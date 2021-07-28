package com.springboot.springbootthymeleafcrudwebapp.Service;

import com.springboot.springbootthymeleafcrudwebapp.Entity.Employee;

import java.util.List;
import java.util.Locale;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployees(Employee employee);
    Employee getEmployeebyId(long id);
    void deleteEmployeeById(long id);
}
