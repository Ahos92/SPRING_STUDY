package com.kgitbank.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kgitbank.model.ChangeSalaryDTO;
import com.kgitbank.model.Employee;

public interface PracticeMapper {

	int saveEmployee(Employee emp);

	List<Employee> getNameBySalary(double salary);
	
	int deleteEmployeeById(int emp_id);
	
	// 매개변수 2개이상 보낼때 DTO객채 or @Param 이용 or arg/param  이용
	int changeSalary(
			@Param("search_id") int search_id, 	 // arg0, param1
			@Param("increment") double increment // arg1, param2
	);
	
	int changeSalary2(ChangeSalaryDTO dto);
	
	
	List<Map<String, Object>> getJoinMap();
}
