package com.dhananjayKr.employeeservice.service;

import com.dhananjayKr.employeeservice.dto.APIResponseDto;
import com.dhananjayKr.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveDepartment(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
