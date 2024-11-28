package com.codingShuttle.springbootweb.springbootweb.service;


import com.codingShuttle.springbootweb.springbootweb.dto.EmployeeDTO;
import com.codingShuttle.springbootweb.springbootweb.entities.EmployeeEntity;
import com.codingShuttle.springbootweb.springbootweb.exceptions.ResourceNotFoundException;
import com.codingShuttle.springbootweb.springbootweb.repositories.EmployeeRepository;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.util.ReflectionUtils;

import java.lang.module.ResolutionException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    // ModelMapper dependency can convert one model to another, allowing separate model remain segregated.

    // Dependency Injection
    private final ModelMapper modelMapper;

    // Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
        // return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getEmail(), employeeEntity.getAge(), employeeEntity.getDateOfJoining(), employeeEntity.getIsActive());
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        // to check if user is authorised to perform this function
        // log something
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);  // EmployeeDTO -> EmployeeEntity
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);   // EmployeeEntity -> EmployeeDTO
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        // Throwing exceptions from Service
        isExistsByEmployeeID(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);  // EmployeeDTO -> EmployeeEntity
        employeeEntity.setId(employeeId);   // setting the id
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean isExistsByEmployeeID(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists)  throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        return true;
    }
    public boolean deleteEmployeeById(Long employeeId) {
        isExistsByEmployeeID(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExistsByEmployeeID(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        // Reflection
        updates.forEach((field, newValue) -> {   // key = field, value = newValue
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);  // Allow access to private/protected fields
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, newValue);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
