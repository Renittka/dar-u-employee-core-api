package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {

    void createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    EmployeeModel getEmployeeById(String employeeId);

    void updateEmployee(EmployeeModel employee);

    void deleteEmployeeById(String employeeId);

}
