package com.shan.angular.college.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract  class AuditModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdat", nullable = false, updatable = false)
	@CreatedDate
    private Date createdAt;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedat", nullable = false)
	private Date updatedAt;

}
