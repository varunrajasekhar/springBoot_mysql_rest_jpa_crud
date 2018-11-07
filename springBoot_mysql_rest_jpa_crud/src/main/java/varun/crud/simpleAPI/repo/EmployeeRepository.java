package varun.crud.simpleAPI.repo;

import org.springframework.data.jpa.repository.*;

import varun.crud.simpleAPI.model.*;;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {

}
