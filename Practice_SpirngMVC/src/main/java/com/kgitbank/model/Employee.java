package com.kgitbank.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// �����͸� ������� Ŭ���� (�������� ���¸� ������ �ڵ�, VO, DTO, model, domain ...)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Component
public class Employee {

	@NonNull
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private double salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;

}

