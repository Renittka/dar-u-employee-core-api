package kz.dar.university.employeecoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, name ="employee_id")
    private String employeeId;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 50)
    private String company;
    @Column(nullable = false, length = 50)
    private String position;
    private String email;
    private double salary;

}
