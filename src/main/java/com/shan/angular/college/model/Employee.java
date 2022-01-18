package com.shan.angular.college.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "empid")
	private int empId;

	@Column(name = "empcode")
	String empCode;

	@Column(name = "empname")
	private String empName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "mob")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "imgpath")
	private String imgPath;

	@Column(name = "isactive")
	private boolean isActive;

	@JsonIgnoreProperties(ignoreUnknown = true, value = {"employees"})
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "deptid")
	Department department;

//	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//	private Photos photo;

	@Column(name = "createdby")
	private int createdBy;

	@Column(name = "updatedby")
	private int updatedBy;

}
