package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

@Data
@Entity
@Builder
@EqualsAndHashCode(exclude = "id")
@Table(name ="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int age;
	@Column(nullable = false)
	private String firstName;
	private String lastName;

	@Tolerate
	public Employee() {
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Address empAddress;

}
