package com.kgitbank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Topping {

	@Autowired
	private Pizza pizza;
}
