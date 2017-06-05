package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;

	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public List<Employee> insert(Employee emp) {
		log.info("Inserting new employee: " + emp);
		empRepo.save(emp);
		return empRepo.findAll();
	}

	@Override
	public List<Employee> save(Employee emp) {
		log.info("Updating employee: " + emp);
		empRepo.save(emp);
		return empRepo.findAll();
	}

	@Override
	public List<Employee> delete(Long empId) {
		empRepo.delete(empId);
		return empRepo.findAll();
	}

	@Override
	public Employee findByEmpId(Long empId) {
		log.info("Retrieving employee for empId: " + empId);
		return empRepo.findById(empId);
	}

	@Override
	public List<Employee> findByAgeLessThan(int age) {
		return empRepo.findByAgeLessThan(age);
	}

}
