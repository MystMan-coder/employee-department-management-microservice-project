package com.dhananjayKr.departmentservice.mapper;

import com.dhananjayKr.departmentservice.dto.DepartmentDto;
import com.dhananjayKr.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
