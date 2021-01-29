package com.kgitbank.controller.practice;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@SessionAttributes(names = {"session1", "session2", "user"})
@Log4j
public class SessionController {

	@GetMapping("/session/")
	public String index() {
		
		return "session/index";
	}
	
	@GetMapping("/session/success")
	public String success(Model model, String session1, String session2) {
		
		model.addAttribute("session1", session1);
		model.addAttribute("session2", session2);
		
		return "session/index";
	}
	
	@GetMapping("/session/check")
	public String check(
				RedirectAttributes rttr,
				@ModelAttribute("session1") String session1,
				@ModelAttribute("session2") String session2
			) {

		log.info(session1);
		log.info(session2);
		
		return "redirect:/session/";
	}
	
	
	@GetMapping("/session/check2")
	public String check2(
				Model model,
				RedirectAttributes rttr,
				@SessionAttribute("session1") String session1,
				@SessionAttribute("session2") String session2
			) {
		
		model.addAttribute("session1", "cc");
		model.addAttribute("session2", "dd");
				
		log.info(session1);
		log.info(session2);
		
		rttr.addFlashAttribute("msg", "세션 값이 변경되었습니다.");
		
		return "redirect:/session/";
	}
	
	
	@GetMapping("session/remove")
	public String remove(SessionStatus status) {		
		// 특정 세션 지우기 , HttpSession session
//		session.removeAttribute("");
//		session.invalidate();
		// 세션 전부삭제
		status.setComplete();
		
		return "redirect:/session/";
	}
	
}
