package varun.crud.simpleAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author varun
 *
 */
@Entity
@Table(name = "emp_details")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"emp_name"}, allowGetters = true)

public class EmployeeDetails implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	private Long emp_id;
	
	@NotBlank
	@Column(name="emp_name")
	private String emp_name;	
	
	
	private String emp_first_name;
	private String emp_last_name;
	private String emp_city;
	private String emp_state;
	private String emp_zip5;
	
	
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_first_name() {
		return emp_first_name;
	}
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}
	public String getEmp_zip5() {
		return emp_zip5;
	}
	public void setEmp_zip5(String emp_zip5) {
		this.emp_zip5 = emp_zip5;
	}
	
}
