package kz.dar.university.employeecoreapi.controller;

import kz.dar.university.employeecoreapi.model.EmployeeModel;
import kz.dar.university.employeecoreapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String check() {

        return "employee-core-api is working at the port " + env.getProperty("local.server.port");

    }

    @PostMapping
    public void createEmployee(@RequestBody @Valid EmployeeModel employee) {

        employeeService.createEmployee(employee);

    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {

        return employeeService.getAllEmployees();

    }

    @GetMapping
    public EmployeeModel getEmployeeById(@RequestParam String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable String employeeId, @RequestBody EmployeeModel employee) {

        employee.setEmployeeId(employeeId);
        employeeService.updateEmployee(employee);

    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable String employeeId) {

        employeeService.deleteEmployeeById(employeeId);

    }

}
