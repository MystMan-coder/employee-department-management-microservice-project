package com.dhananjayKr.employeeservice.mapper;

import com.dhananjayKr.employeeservice.dto.EmployeeDto;
import com.dhananjayKr.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto mapToDto(Employee employee);

    Employee mapToDepartment(EmployeeDto employeeDto);
}
