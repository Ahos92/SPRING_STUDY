package com.kgitbank.model;

import lombok.Data;

// DTO : ���α׷��� ��ϱ� ���� �Դٰ��� �ؾ��ϴ� �����͸� ��°�

// VO : ���̺��� ������ ������ ������

@Data
public class ChangeSalaryDTO {

	private Double increment;
	private Integer employee_id;
	private String job_id;
	private Integer manager_id;
	private Integer department_id;
	
}
