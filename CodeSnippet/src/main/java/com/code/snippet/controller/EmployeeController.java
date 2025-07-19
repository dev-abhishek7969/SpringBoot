package com.code.snippet.controller;

import com.code.snippet.Service.EmployeeService;
import com.code.snippet.dto.EmployeeDto;
import com.code.snippet.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController() {}

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(Integer id){
        Employee employee = employeeService.getEmployee(id);
        EmployeeDto dtoResp = new EmployeeDto();
        dtoResp.getEmployeeMapper(employee);
        return ResponseEntity.ok(dtoResp);
    }

}
