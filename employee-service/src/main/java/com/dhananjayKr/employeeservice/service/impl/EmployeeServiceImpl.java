package com.dhananjayKr.employeeservice.service.impl;

import com.dhananjayKr.employeeservice.dto.APIResponseDto;
import com.dhananjayKr.employeeservice.dto.DepartmentDto;
import com.dhananjayKr.employeeservice.dto.EmployeeDto;
import com.dhananjayKr.employeeservice.entity.Employee;
import com.dhananjayKr.employeeservice.exception.ResourceNotFoundException;
import com.dhananjayKr.employeeservice.mapper.EmployeeMapper;
import com.dhananjayKr.employeeservice.repository.EmployeeRepository;
import com.dhananjayKr.employeeservice.service.APIClient;
import com.dhananjayKr.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private ModelMapper modelMapper;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveDepartment(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),   // -> Id set to null as there is no id coming from JSON and no automatic generation in DTo class
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

//            //using mapstruct
//            Employee employee = EmployeeMapper.MAPPER.mapToDepartment(employeeDto);

//        //using model mapper
//        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);//ID set to 1,2,3,4,... while saving to repo by mysql as insert will auto generate id

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(), //ID set to 1,2,3,4,... from entity to dto
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

//        //using mapstruct
//        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToDto(savedEmployee);

//         //using model mappeer
//         EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);


        return savedEmployeeDto;

    }

    @Override
//    public EmployeeDto getEmployeeById(Long id) {
      public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id)
        );


//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

//        //using mapstruct
//        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToDto(employee);

//        //using moddel mapper
//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

//        return employeeDto;

        return apiResponseDto;
    }
}
