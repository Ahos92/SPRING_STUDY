package com.kgitbank.model;

import lombok.Data;

// DTO : 프로그램을 운영하기 위해 왔다갔다 해야하는 데이터를 담는곳

// VO : 테이블에서 데이터 꺼내서 담을곳

@Data
public class ChangeSalaryDTO {

	private Double increment;
	private Integer employee_id;
	private String job_id;
	private Integer manager_id;
	private Integer department_id;
	
}
