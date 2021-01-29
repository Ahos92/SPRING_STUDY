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
		
		// Attribute�� ���� �߰��ϰ� ������ �Ű������� ModelŸ���� �߰��ϸ� �˾Ƽ� �ν��Ͻ��� ��޵ȴ�.
		model.addAttribute("serverTime", new Date());
		
		// �Ķ���� �̸��� �Ű����� �̸��� ��ġ��Ű�� request.getParameter()�� ���ص� �˾Ƽ� �޴´�.
		// Ÿ�Ե� �˾Ƽ� ��ȯ���ش�.
		log.info("param01 : " + new User(name, age));
		
		return "home";
	}
	
	
	// �Ķ���� �̸��� �Ű����� �̸��� ��ġ��Ű�� ���� ���� ��
	@GetMapping("02")
	public String param02(Model model, 
							@RequestParam("name")  String name1, 
							@RequestParam("age") int age1) {
		
		model.addAttribute("serverTime", new Date());
		
		log.info("param02 : " + new User(name1, age1));
		
		return "home";
	}
	
	// http://localhost:8080/practice_mvc/param/03?name=�Ѹ�&age=123
	// http://localhost:8080/practice_mvc/param/03?name=�Ѹ�&age=123&cats=������, �۸���, �ٵ���
	// http://localhost:8080/practice_mvc/param/03?name=�Ѹ�&age=123&cats=������, �۸���, �ٵ���&joinDate=2021-01-26
	@GetMapping("03")
	public String parma03(Model model, User user) {
		model.addAttribute("serverTime", new Date());
		
		// VO�� �ʵ��� �Ķ���� ���� ��ġ ��Ű�� �˾Ƽ� VO�� ���� ä�� �ν��Ͻ��� �����Ǽ� ���´�.
		log.info("param03 : " + user);
		
		return "home";
	}
	
	// http://localhost:8080/practice_mvc/param/04?cats=������, �۸���, �ٵ���
	// CheckBoxó�� ���� �̸����� �������� �Ķ���Ͱ��� �޾ƾ� �ϴ� ��� 
	@GetMapping("04")
	public String param04(Model model, @ModelAttribute("cats") String[] cats) {
		model.addAttribute("serverTime", new Date());
		
		log.info("param04 : " + Arrays.toString(cats));
		
		return "home";
	}

}