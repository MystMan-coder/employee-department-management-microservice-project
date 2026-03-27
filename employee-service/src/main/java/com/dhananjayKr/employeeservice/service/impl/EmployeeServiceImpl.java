package com.dhananjayKr.employeeservice.service.impl;

import com.dhananjayKr.employeeservice.dto.EmployeeDto;
import com.dhananjayKr.employeeservice.entity.Employee;
import com.dhananjayKr.employeeservice.mapper.EmployeeMapper;
import com.dhananjayKr.employeeservice.repository.EmployeeRepository;
import com.dhananjayKr.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveDepartment(EmployeeDto employeeDto) {
//        Employee employee = new Employee(
//                employeeDto.getId(),   // -> Id set to null as there is no id coming from JSON and no automatic generation in DTo class
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

//            //using mapstruct
//            Employee employee = EmployeeMapper.MAPPER.mapToDepartment(employeeDto);

        //using model mapper
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);//ID set to 1,2,3,4,... while saving to repo by mysql as insert will auto generate id

//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(), //ID set to 1,2,3,4,... from entity to dto
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

//        //using mapstruct
//        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToDto(savedEmployee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto;

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
      Employee employee = employeeRepository.findById(id).get();

//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

//        //using mapstruct
//        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToDto(employee);

        //using moddel mapper
        EmployeeDto savedEmployeeDto = modelMapper.map(employee, EmployeeDto.class);

        return savedEmployeeDto;
    }
}
