package com.RESTAPIapp.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RESTAPIapp.entity.Employee;
import com.RESTAPIapp.exception.CustomException;
import com.RESTAPIapp.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	 private EmployeeRepo eRepo;
	
	public List<Employee> getAllEmployee(){
		List<Employee> emp1=(List<Employee>) eRepo.findAll();
		return emp1;
				
		
	}

	public Employee saveEmplyee(Employee emp) {
		if(emp.getName().isEmpty()||emp.getName().length()==0)
		{
			throw new CustomException("1","Name is Empty");
		}
		Employee emp1=eRepo.save(emp);
		return emp1;
	}

	public Employee getEmployeeById(int ids) {
		 
	
			 return eRepo.findById(ids).get();
			
	
	
	}

	public Employee updateEmployee(Employee employee) {
		 Employee emp5=eRepo.save(employee);
		return emp5;
	}

	public void deleteEmployeeById(int id) {
		
		eRepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
