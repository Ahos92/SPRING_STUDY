package com.kgitbank.controller.practice;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/exercise/*")
@Log4j
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
	
	@GetMapping("ex04")
	public String ex04(RedirectAttributes rttr) {
		log.info("ex04 �Դٰ�");
		
		// �𵨿� �߰��� attribute�� �����̷�Ʈ�ÿ��� get��� �Ķ���ͷ� �ּҵڿ� �߰��ȴ�.
		rttr.addAttribute("visited", "ex04");
		
		// �����̷�Ʈ�� 1ȸ�� ��Ʈ����Ʈ�� �߰� �Ҽ� �ִ�.
		rttr.addFlashAttribute("name", "ex04");
		
		// ���������� �����̷�Ʈ ó�� (ContextPath�� �ڵ����� �����ش�)
		return "redirect:/exercise/ex01";
	}
	
	
	@GetMapping("session")
	public String session(
			@SessionAttribute("session1") String s1,
			@SessionAttribute("session2") String s2
			) {
		
		// �ٸ� ��Ʈ�ѷ������� @ModelAttribute�� ã�� �� ���� ������ @SessionAttribute�� �̿��Ѵ�
		log.info(s1);
		log.info(s2);
		
		return "redirect:/session/";
	}
}
