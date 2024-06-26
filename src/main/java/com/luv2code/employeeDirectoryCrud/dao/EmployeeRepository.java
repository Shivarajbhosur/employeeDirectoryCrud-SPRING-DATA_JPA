package com.luv2code.employeeDirectoryCrud.dao;

import com.luv2code.employeeDirectoryCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //thats is no need to wirte morecode
    //no need of implimentaiooin class also

}
