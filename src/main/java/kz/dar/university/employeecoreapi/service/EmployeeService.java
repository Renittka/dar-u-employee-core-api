package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService {

    HashMap<String, EmployeeModel> employeeMap = new HashMap<>();

    {

        EmployeeModel employee = new EmployeeModel(UUID.randomUUID().toString(), "Maria", "Smith", "DAR",
                "Software Engineer", "example@gmail.com", 200000);
        employeeMap.put(employee.getEmployeeId(), employee);

    }


    @Override
    public void createEmployee(EmployeeModel employee) {

        if (employee.getEmployeeId() == null) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeMap.put(employee.getEmployeeId(), employee);

    }

    @Override
    public List<EmployeeModel> getAllEmployees() {

        return employeeMap.values().stream().toList();

    }

    @Override
    public EmployeeModel getEmployeeById(String employeeId) {

        return employeeMap.get(employeeId);

    }

    @Override
    public void updateEmployee(EmployeeModel employee) {

        String employeeId = employee.getEmployeeId();
        if(employeeMap.containsKey(employeeId)) {
            employeeMap.put(employeeId, employee);
        }

    }

    @Override
    public void deleteEmployeeById(String employeeId) {

        employeeMap.remove(employeeId);

    }
}
