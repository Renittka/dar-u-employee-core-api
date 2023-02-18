package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.model.EmployeeRequest;
import kz.dar.university.employeecoreapi.model.EmployeeResponse;
import kz.dar.university.employeecoreapi.repository.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest employee);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(String employeeId);

    void updateEmployee(EmployeeRequest employee);

    void deleteEmployeeById(String employeeId);

}
