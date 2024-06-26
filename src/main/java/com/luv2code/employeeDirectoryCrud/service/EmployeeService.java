package com.luv2code.employeeDirectoryCrud.service;

import com.luv2code.employeeDirectoryCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);
}
