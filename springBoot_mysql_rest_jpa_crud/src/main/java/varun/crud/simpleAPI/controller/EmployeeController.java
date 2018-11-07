package varun.crud.simpleAPI.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import varun.crud.simpleAPI.dao.EmployeeDAO;
import varun.crud.simpleAPI.model.EmployeeDetails;

@RestController
@Controller
@RequestMapping("/empDetails")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@PostMapping("/employees")
	public EmployeeDetails createEmployee(@Valid @RequestBody EmployeeDetails emp) {
		return employeeDAO.save(emp);
	}
	
	@GetMapping("/employees")
	public List<EmployeeDetails> getAllEmployees() {
		return employeeDAO.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<EmployeeDetails>> getEmployeeId(@PathVariable(value="id") Long empid, @Valid @RequestBody EmployeeDetails empDetails) {
			Optional<EmployeeDetails> emp = employeeDAO.findById(empid);
			
			if(emp == null) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody EmployeeDetails empDetails) {
			Optional<EmployeeDetails> empId = employeeDAO.findById(empid);
			EmployeeDetails emp = new EmployeeDetails();
			
			if(empId == null) {
				return ResponseEntity.notFound().build();
			}
			emp.setEmp_name(empDetails.getEmp_name());
			
			EmployeeDetails updateEmp = employeeDAO.save(emp);
			
			return ResponseEntity.ok().body(updateEmp);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<EmployeeDetails> deleteEmployee(@PathVariable(value="id") Long empid) {
		Optional<EmployeeDetails> empId = employeeDAO.findById(empid);
		EmployeeDetails emp = new EmployeeDetails();
		
		if(empId == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
	}
}
