package com.kgitbank.controller.practice;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kgitbank.model.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/param/*")
@Log4j
public class ParamController {
	
	@GetMapping("01")
	public String param01(Model model, 
							@ModelAttribute("name") String name, 
							@ModelAttribute("age") int age) {
		
		// Attribute에 값을 추가하고 싶으면 매개변수에 Model타입을 추가하면 알아서 인스턴스가 배달된다.
		model.addAttribute("serverTime", new Date());
		
		// 파라미터 이름과 매개변수 이름을 일치시키면 request.getParameter()를 안해도 알아서 받는다.
		// 타입도 알아서 변환해준다.
		log.info("param01 : " + new User(name, age));
		
		return "home";
	}
	
	
	// 파라미터 이름과 매개변수 이름을 일치시키고 싶지 않을 때
	@GetMapping("02")
	public String param02(Model model, 
							@RequestParam("name")  String name1, 
							@RequestParam("age") int age1) {
		
		model.addAttribute("serverTime", new Date());
		
		log.info("param02 : " + new User(name1, age1));
		
		return "home";
	}
	
	// http://localhost:8080/practice_mvc/param/03?name=둘리&age=123
	// http://localhost:8080/practice_mvc/param/03?name=둘리&age=123&cats=강아지, 멍멍이, 바둑이
	// http://localhost:8080/practice_mvc/param/03?name=둘리&age=123&cats=강아지, 멍멍이, 바둑이&joinDate=2021-01-26
	@GetMapping("03")
	public String parma03(Model model, User user) {
		model.addAttribute("serverTime", new Date());
		
		// VO의 필드명과 파라미터 명을 일치 시키면 알아서 VO의 값을 채운 인스턴스가 생성되서 들어온다.
		log.info("param03 : " + user);
		
		return "home";
	}
	
	// http://localhost:8080/practice_mvc/param/04?cats=강아지, 멍멍이, 바둑이
	// CheckBox처럼 같은 이름으로 여러개의 파라미터값을 받아야 하는 경우 
	@GetMapping("04")
	public String param04(Model model, @ModelAttribute("cats") String[] cats) {
		model.addAttribute("serverTime", new Date());
		
		log.info("param04 : " + Arrays.toString(cats));
		
		return "home";
	}

}