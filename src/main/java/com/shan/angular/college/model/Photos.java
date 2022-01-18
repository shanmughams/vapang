package com.shan.angular.college.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "photos")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Photos implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//
//	@Column(name = "photoimg")
//	private Blob photoimg;
//
//	@OneToOne(fetch = FetchType.LAZY)
////	@JoinColumn(name = "empid")
//	  @MapsId
//	private Employee employee;

}
