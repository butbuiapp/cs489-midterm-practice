package miu.asd.midtermpractice.service;

import lombok.RequiredArgsConstructor;
import miu.asd.midtermpractice.model.Employee;
import miu.asd.midtermpractice.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public void updateEmployee(int id, Employee e) {
        employeeRepository.findById(id).ifPresentOrElse(
                existingEmp -> {
                    existingEmp.setFirstName(e.getFirstName());
                    existingEmp.setLastName(e.getLastName());
                    existingEmp.setSalary(e.getSalary());

                },
                () -> {
                    throw new RuntimeException("Employee not found");
                }
        );
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id).ifPresentOrElse(
                existingEmp -> {
                    employeeRepository.delete(existingEmp);
                },
                () -> {
                    throw new RuntimeException("Employee not found");
                }
        );
    }

    @Override
    public List<Employee> findByFirstName(String name) {
        return employeeRepository.findByFirstName(name);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll(
                Sort.by("salary")
                        .and(Sort.by("lastName").reverse()));
    }
}
