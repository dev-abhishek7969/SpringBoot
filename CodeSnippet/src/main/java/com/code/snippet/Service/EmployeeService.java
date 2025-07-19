package com.code.snippet.Service;

import com.code.snippet.Repository.EmployeeRepository;
import com.code.snippet.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public Employee getEmployee(Integer empId){
        return  new Employee(1,"Abhishek","Computer Science",30);
    }
}
