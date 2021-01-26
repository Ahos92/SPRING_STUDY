package com.kgitbank.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exercise/*")
public class ExerciseController {
	
	//	url 디자인도 필요하다
	// @RequestMapping(value="/ex/01", method = RequestMethod.GET)
	// @GetMapping("ex/01")
	// String 리턴
	@GetMapping("ex01")
	public String ex01() {
		
		return "exercise/ex01";
	}
	
	// 리턴 타입이 없는 컨트롤러 경우 접속한 URL로 뷰를 찾는다
	@GetMapping("ex02")
	public void ex02() {
		
	}
	
	// ModelAndView 리턴
	@GetMapping("ex03")
	public ModelAndView ex03() {
		// String + Model(Attribute 싣는 곳)
		ModelAndView mnv = new ModelAndView();
		
		mnv.addObject("load", "success");
		mnv.setViewName("exercise/ex03");
		
		return mnv;
	}
	
}
