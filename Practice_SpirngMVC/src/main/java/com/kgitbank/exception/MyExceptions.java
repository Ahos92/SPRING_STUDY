package com.kgitbank.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// exception »ç¿ë
@ControllerAdvice
@Log4j
public class MyExceptions {

	@ExceptionHandler(Exception.class)
	public String commonException(Exception e, Model model) {
		log.error("Exception : " + e.getMessage());
		
		model.addAttribute(e);
		log.error(model);
		
		return "errorPage";
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandler(Exception e, Model model) {
		log.error("NoHandler : " + e.getMessage());
		
		model.addAttribute(e);
		log.error(model);
		
		return "errorPage";
	}
}
