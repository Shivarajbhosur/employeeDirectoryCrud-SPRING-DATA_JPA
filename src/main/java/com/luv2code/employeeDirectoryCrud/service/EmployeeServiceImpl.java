package com.luv2code.employeeDirectoryCrud.service;

import com.luv2code.employeeDirectoryCrud.dao.EmployeeRepository;
import com.luv2code.employeeDirectoryCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {

        employeeRepository = theemployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee=null;
        if (result.isPresent()){
            theEmployee=result.get();
        }
        else {
            throw new RuntimeException("given id is not found:" + id);

        }        return theEmployee;
    }

    @Override
    //@Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
   // @Transactional jpa has provide functinlity
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
