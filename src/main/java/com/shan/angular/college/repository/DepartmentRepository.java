package com.shan.angular.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shan.angular.college.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
