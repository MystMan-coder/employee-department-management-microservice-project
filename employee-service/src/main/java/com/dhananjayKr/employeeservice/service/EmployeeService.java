package com.dhananjayKr.employeeservice.service;

import com.dhananjayKr.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveDepartment(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
