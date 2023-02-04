package kz.dar.university.employeecoreapi.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String employeeId;
    @NotNull(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Surname can not be empty")
    @Size(min = 2, max = 16, message = "Surname must be greater than 2, and less than 16")
    private String surname;
    private String company;
    private String position;
    @Email
    private String email;
    private double salary;

}
