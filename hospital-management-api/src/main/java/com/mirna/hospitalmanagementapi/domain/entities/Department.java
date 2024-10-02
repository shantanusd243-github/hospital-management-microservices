package com.mirna.hospitalmanagementapi.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	private String short_name;
	private String department_name;
}
