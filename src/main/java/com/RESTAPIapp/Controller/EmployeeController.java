package com.RESTAPIapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RESTAPIapp.entity.Employee;
import com.RESTAPIapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eServ;
	
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
    
		List<Employee> emp=eServ.getAllEmployee();
	    System.out.println(emp);
	    return emp;
    }
    
    @GetMapping("/employee/{ids}")
    public Employee getEmployeeById(@PathVariable("ids") int ids) {
		
    	Employee emp2=eServ.getEmployeeById(ids);
    	return emp2;
    	
    }
    
    @PostMapping("/saveEmployee")
    public Employee saveEmplyee(@RequestBody Employee emp) {
		
    	Employee emp1=eServ.saveEmplyee(emp);
    	return emp;
    	
    }
    
    @PutMapping("/updateEmp")
    public Employee update (@RequestBody Employee employee) {
		Employee emp4=eServ.updateEmployee(employee);
    	return emp4;
    	
    }
	
    @DeleteMapping("/deleteEmp/{ids}")
    
   public void delet(@PathVariable("ids") int id) {
    	eServ.deleteEmployeeById(id);
    	}
    }
   


