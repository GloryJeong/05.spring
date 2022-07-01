package com.spring.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;

@Controller
@SessionAttributes({"job","age","id","customer","login"})
public class SessionController {
	
	@GetMapping(value ="/cookieTest.do")
	public String cookieTest(Model model,@CookieValue String id) {
		model.addAttribute("id",id);	
		System.out.println(id);
		return "redirect:/cookieView.jsp";
	}
	@GetMapping(value ="session/sessionTest1.do")
	public String sessionTest1(HttpSession session) {
		session.setAttribute("job","programmer");
		System.out.println(session.getAttribute("customer"));
		return "redirect:/sessionView1.jsp";
	}
	
//	@GetMapping(value ="session/jobDelete.do")
//	public String jobDelete(HttpSession session) {
//		session.removeAttribute("job");
//		return "redirect:/sessionView1.jsp";
//	}
	@GetMapping(value ="session/jobDelete.do")
	public String jobDelete(@ModelAttribute("job") String job,SessionStatus status) {
		status.setComplete();
		System.out.println(job);
		return "redirect:/sessionView1.jsp";
	}
	
//	@GetMapping(value ="session/customerDelete.do")
//	public String customerDelete(HttpSession session) {
//		session.removeAttribute("customer");
//		return "redirect:/sessionView1.jsp";
//	}
	@GetMapping(value ="session/sessionDelete.do")
	public String customerDelete(@ModelAttribute("id") String id,@ModelAttribute("age") String age,SessionStatus status) {
		
		System.out.println(id);
		System.out.println(age);
		return "redirect:/sessionView1.jsp";
	}
	@GetMapping(value="session/sessionTest2.do")
	public String sessionTest2DTO(Model model,Customer customer) {
		System.out.println(customer);
		model.addAttribute("customer",customer);
		return "redirect:/sessionView2.jsp";
	}
	@GetMapping(value ="session/customerDelete.do")
	public String sessionCustomerDelete(SessionStatus status) {
		status.setComplete();
		return "redirect:/sessionView2.jsp";
	}
	
	@GetMapping(value = "session/loginForm.do")
	public String moveLoginForm() {	
		return "loginForm";
	}
	@PostMapping(value = "session/login.do")
	public String login(String password,HttpSession session) {
		// 조건 : pw가 1234일 때, admin 인정
		// 만약 아니라면, index.jsp로 화면 전환
		System.out.println(password);
		if("1234".equals(password)) {
			session.setAttribute("login","admin");
		}
		return "redirect:/index.jsp";
	}
	@GetMapping(value="/session/logout.do")
	public String logout(HttpSession session) {
		// index.jsp의 로그아웃 버튼 클릭시
		// 해당 세션은 해제 후 -> index.jsp로 화면 전환
		session.removeAttribute("login");
		
		return "redirect:/index.jsp";
	}
	
	
	
}
