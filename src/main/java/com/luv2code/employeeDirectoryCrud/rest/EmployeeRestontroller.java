package com.luv2code.employeeDirectoryCrud.rest;

import com.luv2code.employeeDirectoryCrud.entity.Employee;
import com.luv2code.employeeDirectoryCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestontroller {
     //added service layer so no need of dao injection do service layer injection

    //private EmployeeDAO employeeDAO;
    private  EmployeeService employeeService;

    @Autowired
    public EmployeeRestontroller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee>  findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId)
    {
        Employee theEmployee =employeeService.findById(employeeId);

        return theEmployee;
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee theEmployee){
        //if cloebt pass the id in json then set id as o this is force to save new item
    //insted of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee theEmployee){
        Employee theeEmployee = employeeService.save(theEmployee);
        return theeEmployee;
    }


    }

