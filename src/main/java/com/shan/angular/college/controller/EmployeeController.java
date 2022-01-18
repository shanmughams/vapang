package com.shan.angular.college.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shan.angular.college.common.exception.ResourceNotFoundException;
import com.shan.angular.college.model.Employee;
import com.shan.angular.college.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getAByEmployeeId(@PathVariable int id) throws ResourceNotFoundException {
		Employee d = employeeRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(d);
	}

	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee d) {
		return employeeRepository.save(d);
	}

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp)
			throws ResourceNotFoundException {

		Employee d = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		d.setActive(true);
		

		Employee savedDept = employeeRepository.save(d);
		return ResponseEntity.ok(savedDept);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDept(@PathVariable int id) throws ResourceNotFoundException {
		Employee d = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		employeeRepository.delete(d);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
