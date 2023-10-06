package com.clean.code.springboot.web.res;

import com.clean.code.springboot.domain.Employee;
import com.clean.code.springboot.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final  EmployeeRepository employeeService;

    public EmployeeResource(EmployeeRepository employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Employee employee = employeeService.findById(id).get();
       employeeService.delete(employee);
        return ResponseEntity.ok("row deleted");
    }

    @GetMapping("/employees/all")
    public ResponseEntity getAll() {
        List<Employee> employeesList = employeeService.findAll();
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/employees/{name}")
    public ResponseEntity getByName(@PathVariable String name) {

        List<Employee> employeesList = employeeService.findByNameQueryNative(name);
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/employees")
    public ResponseEntity getByNameLike(@RequestParam String name) {
        List<Employee> employeeList = employeeService.findByNameLikeQueryNative(name);
        return ResponseEntity.ok(employeeList);
    }






}
