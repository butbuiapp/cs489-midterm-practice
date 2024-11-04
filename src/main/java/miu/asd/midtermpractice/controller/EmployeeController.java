package miu.asd.midtermpractice.controller;


import lombok.RequiredArgsConstructor;
import miu.asd.midtermpractice.model.Employee;
import miu.asd.midtermpractice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<List<Employee>> findEmployeeByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(employeeService.findByFirstName(firstName), HttpStatus.OK);
    }


}
