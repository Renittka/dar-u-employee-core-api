package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.model.EmployeeRequest;
import kz.dar.university.employeecoreapi.model.EmployeeResponse;
import kz.dar.university.employeecoreapi.repository.EmployeeEntity;
import kz.dar.university.employeecoreapi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    ModelMapper mapper = new ModelMapper();

    {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employee) {

        employee.setEmployeeId(UUID.randomUUID().toString());

        EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
        EmployeeEntity result = employeeRepository.save(entity);

        return mapper.map(result, EmployeeResponse.class);

        /*
        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmployeeId(employee.getEmployeeId());
        entity.setName(employee.getName());
        entity.setSurname(employee.getSurname());
        entity.setCompany(employee.getCompany());
        entity.setEmail(employee.getEmail());
        entity.setSalary(employee.getSalary());
         */


    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.getEmployeeEntitiesBy()
                .stream()
                .map(employee -> mapper.map(employee, EmployeeResponse.class))
                .toList();

    }

    @Override
    public EmployeeResponse getEmployeeById(String employeeId) {

        EmployeeEntity result = employeeRepository.getEmployeeEntityByEmployeeId(employeeId);
        return mapper.map(result, EmployeeResponse.class);

    }

    @Override
    public void updateEmployee(EmployeeRequest employee) {


    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteEmployeeEntityByEmployeeId(employeeId);
    }

}
