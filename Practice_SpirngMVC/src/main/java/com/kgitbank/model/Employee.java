package com.kgitbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// 데이터를 담기위한 클래스 (데이터의 형태를 정의한 코드, VO, DTO, model, domain ...)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {

	@NonNull
	private String first_name;
	private String last_name;
	private String employee_name;

}

