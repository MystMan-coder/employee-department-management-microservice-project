package com.dhananjayKr.departmentservice.service.impl;

import com.dhananjayKr.departmentservice.dto.DepartmentDto;
import com.dhananjayKr.departmentservice.entity.Department;
import com.dhananjayKr.departmentservice.exception.ResourceNotFoundException;
import com.dhananjayKr.departmentservice.mapper.DepartmentMapper;
import com.dhananjayKr.departmentservice.repository.DepartmentRepository;
import com.dhananjayKr.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
//        Department department = new Department(
//                departmentDto.getId(),   // -> Id set to null as there is no id coming from JSON and no automatic generation in DTo class
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );

//        //using mapstruct
//        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        //using model mapper
        Department department = modelMapper.map(departmentDto, Department.class);


        Department savedDepartment = departmentRepository.save(department);//ID set to 1,2,3,4,... while saving to repo by mysql as insert will auto generate id

//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                savedDepartment.getId(), //ID set to 1,2,3,4,... from entity to dto
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

//        //using mapstruct
//        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDto(savedDepartment);

        //using model mapper
          DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return savedDepartmentDto;

    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);

        if (department == null) {
            throw new ResourceNotFoundException(
                    "Department not found with code: " + code
            );
        }



//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

//        //using mapstruct
//        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDto(department);

        //using model mapper
        DepartmentDto savedDepartmentDto = modelMapper.map(department, DepartmentDto.class);

        return savedDepartmentDto;
    }
}
