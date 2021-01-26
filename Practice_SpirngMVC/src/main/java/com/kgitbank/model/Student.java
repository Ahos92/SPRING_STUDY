package com.kgitbank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Student {
	
	@Autowired
	private Teacher teacher;
}
