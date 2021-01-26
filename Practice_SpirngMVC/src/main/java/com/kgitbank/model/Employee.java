package com.kgitbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// �����͸� ������� Ŭ���� (�������� ���¸� ������ �ڵ�, VO, DTO, model, domain ...)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {

	@NonNull
	private String first_name;
	private String last_name;
	private String employee_name;

}

