package kz.dar.university.employeecoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> getEmployeeEntitiesBy();

    EmployeeEntity getEmployeeEntityByEmployeeId(String employeeId);

    void deleteEmployeeEntityByEmployeeId(String employeeId);

}
