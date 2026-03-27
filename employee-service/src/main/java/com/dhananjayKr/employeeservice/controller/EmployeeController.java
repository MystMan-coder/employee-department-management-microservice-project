package com.dhananjayKr.employeeservice.controller;

import com.dhananjayKr.employeeservice.dto.EmployeeDto;
import com.dhananjayKr.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto departmentDto) {
        EmployeeDto savedEmployeeDto = employeeService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getDepartmentByCode(@PathVariable("id") Long employeeId) {
        EmployeeDto savedEmployeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(savedEmployeeDto);
    }
}
