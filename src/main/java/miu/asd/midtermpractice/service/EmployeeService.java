package miu.asd.midtermpractice.service;

import miu.asd.midtermpractice.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee e);
    void updateEmployee(int id, Employee e);
    void deleteEmployee(int id);
    List<Employee> findByFirstName(String name);

    List<Employee> findAllEmployees();
}
