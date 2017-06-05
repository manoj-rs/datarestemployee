package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	List<Employee> insert(Employee emp);

	List<Employee> save(Employee emp);

	List<Employee> delete(Long empId);

	Employee findByEmpId(Long empId);

	List<Employee> findByAgeLessThan(int age);

}
