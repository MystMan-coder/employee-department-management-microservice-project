package com.dhananjayKr.departmentservice.service;

import com.dhananjayKr.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
