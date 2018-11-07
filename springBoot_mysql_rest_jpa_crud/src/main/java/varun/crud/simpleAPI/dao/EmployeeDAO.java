package varun.crud.simpleAPI.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import varun.crud.simpleAPI.model.EmployeeDetails;
import varun.crud.simpleAPI.repo.EmployeeRepository;

@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeDetails save(EmployeeDetails emp) {
		return employeeRepository.save(emp);
	}
	
	public List<EmployeeDetails> findAll() {
		return employeeRepository.findAll();
	}
	
	public void delete(EmployeeDetails emp) {
		employeeRepository.delete(emp);
	}
	
	public Optional<EmployeeDetails> findById(Long empid) {
		return employeeRepository.findById(empid);
	}
}
