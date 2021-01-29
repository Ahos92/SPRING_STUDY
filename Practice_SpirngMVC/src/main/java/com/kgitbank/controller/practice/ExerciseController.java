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
	
	@GetMapping("ex04")
	public String ex04(RedirectAttributes rttr) {
		log.info("ex04 왔다감");
		
		// 모델에 추가한 attribute는 리다이렉트시에는 get방식 파라미터로 주소뒤에 추가된다.
		rttr.addAttribute("visited", "ex04");
		
		// 리다이렉트시 1회성 어트리뷰트를 추가 할수 있다.
		rttr.addFlashAttribute("name", "ex04");
		
		// 스프링에서 리다이렉트 처리 (ContextPath를 자동으로 더해준다)
		return "redirect:/exercise/ex01";
	}
	
	
	@GetMapping("session")
	public String session(
			@SessionAttribute("session1") String s1,
			@SessionAttribute("session2") String s2
			) {
		
		// 다른 컨트롤러에서는 @ModelAttribute를 찾을 수 없기 떄문에 @SessionAttribute를 이용한다
		log.info(s1);
		log.info(s2);
		
		return "redirect:/session/";
	}
}
