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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shan.angular.college.common.exception.ResourceNotFoundException;
import com.shan.angular.college.model.Department;
import com.shan.angular.college.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@GetMapping("departments")
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@GetMapping("departments/{id}")
	public ResponseEntity<Department> getAByDepartmentId(@PathVariable int id) throws ResourceNotFoundException {
		Department d = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		return ResponseEntity.ok(d);
	}

	@PostMapping("departments")
	public Department createDepartment(@RequestBody Department d) {
		return departmentRepository.save(d);
	}

	@PutMapping("departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department dept)
			throws ResourceNotFoundException {

		Department d = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));

		d.setActive(true);
		d.setDeptName(dept.getDeptName());
		d.setDeptId(dept.getDeptId());
		d.setOrdNo(dept.getOrdNo());

		Department savedDept = departmentRepository.save(d);
		return ResponseEntity.ok(savedDept);

	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDept(@PathVariable int id) throws ResourceNotFoundException {
		Department d = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));

		departmentRepository.delete(d);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	

	@PostMapping("/departments")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@RequestParam int id) throws ResourceNotFoundException {
		Department d = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));

		d.setActive(false);
		Department savedDept =departmentRepository.save(d);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

	
}
