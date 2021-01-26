package com.kgitbank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
public class Uniform {

	@Setter(onMethod_ = {@Autowired})
	private Student student;

}
