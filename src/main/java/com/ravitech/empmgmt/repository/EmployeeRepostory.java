package com.ravitech.empmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ravitech.empmgmt.model.Employee;


/**
 * @author Ravindra
 *
 */
@Repository
public interface EmployeeRepostory extends JpaRepository<Employee, Long>{
	
	//Custom query
	@Query(value="select * from emp_mgmt_db.employee where mobile_no= :mobile_no", nativeQuery=true)
	public List<Employee> findEmplyeeByMobile(@Param("mobile_no") String mobile);

}
