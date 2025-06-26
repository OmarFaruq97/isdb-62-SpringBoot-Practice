package com.isdb62.employee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.isdb62.employee.service.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isdb62.employee.model.Employee;
import com.isdb62.employee.service.EmployeeService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    private final FileStorageService storageService;

    public EmployeeController(EmployeeService service, FileStorageService storageService) {
        this.service = service;
        this.storageService = storageService;
    }

    @PostMapping
    public Employee saveEmp(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PostMapping("/{employeeId}/upload")
    public ResponseEntity<?> uploadFile(@PathVariable Integer employeeId,
                                        @RequestParam("file") MultipartFile file) {
        try {
            String saveFileName = storageService.storeFile(file);

            String accessUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/imageUrl/")
                    .path(saveFileName)
                    .toUriString();

            Employee empById = service.getEmpById(employeeId);
            empById.setImage(accessUrl);

            service.updateEmp(employeeId, empById);

            return ResponseEntity.ok(Map.of("message", "File Uploaded", "url", accessUrl));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable int id) {
        Employee empById = service.getEmpById(id);
        return empById;
    }

    @GetMapping
    public List<Employee> getAllEmp() {
        List<Employee> allEmp = service.getAllEmp();
        return allEmp;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable int id, @RequestBody Employee employee) {
        Employee updated = service.updateEmp(id, employee);
        return updated;
    }

    @GetMapping("search/{name}")
    public List<Employee> getEmpByName(@PathVariable String name) {
        List<Employee> name1 = service.getempByname(name);
        return name1;
    }
}
