package office.nvc.office.repository;

import org.springframework.data.repository.CrudRepository;

import office.nvc.office.model.Employee;
import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

    List<Employee> findByName(String name);
    List<Employee> findBySalaryGreaterThan(int salary);

}
