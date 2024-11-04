package miu.asd.midtermpractice.repository;

import miu.asd.midtermpractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
    //List<Employee> findAllOrderBySalaryAndLastName();
}
