package com.kgitbank.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

	@NonNull
	private String name;
	@NonNull
	private Integer age;
	
	private String[] cats;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	
}
