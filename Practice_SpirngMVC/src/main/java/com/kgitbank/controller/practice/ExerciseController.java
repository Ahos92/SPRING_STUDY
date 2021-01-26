package com.kgitbank.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exercise/*")
public class ExerciseController {
	
	//	url �����ε� �ʿ��ϴ�
	// @RequestMapping(value="/ex/01", method = RequestMethod.GET)
	// @GetMapping("ex/01")
	// String ����
	@GetMapping("ex01")
	public String ex01() {
		
		return "exercise/ex01";
	}
	
	// ���� Ÿ���� ���� ��Ʈ�ѷ� ��� ������ URL�� �並 ã�´�
	@GetMapping("ex02")
	public void ex02() {
		
	}
	
	// ModelAndView ����
	@GetMapping("ex03")
	public ModelAndView ex03() {
		// String + Model(Attribute �ƴ� ��)
		ModelAndView mnv = new ModelAndView();
		
		mnv.addObject("load", "success");
		mnv.setViewName("exercise/ex03");
		
		return mnv;
	}
	
}
