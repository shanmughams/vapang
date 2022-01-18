package com.shan.angular.college.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Getter
@EqualsAndHashCode(exclude = { "employees" })

@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Department extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "deptid")
	private int deptId;

	@Column(name = "deptname")
	String deptName;

	@Column(name = "ordno")
	private int ordNo;

	@Column(name = "isactive")
	private boolean isActive;

	@JsonIgnoreProperties(ignoreUnknown = true, value = { "department" })
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employees;

	@Column(name = "updatedby")
	private int updatedBy;

	@Column(name = "createdby")
	private int createdBy;

}
