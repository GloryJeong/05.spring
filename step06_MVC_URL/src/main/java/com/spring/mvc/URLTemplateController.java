package com.spring.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class URLTemplateController {
	
// 	http://localhost:8080/mvc/urlTest.do/1
	@GetMapping(value = "urlTest.do/{id}")
	public String urlTest1(@PathVariable String id) {
		System.out.println("value - "+id );
		return "forward:/view.jsp";
	}
//	http://localhost:8080/mvc/urlTest.do/1/home/27
	@GetMapping(value = "urlTest.do/{id}/home/{age}")
	public String urlTest(Model model,@PathVariable String id,@PathVariable String age) {
		
		model.addAttribute("id",id);
		model.addAttribute("age",age);
		System.out.println("id = "+id);
		System.out.println("age = "+age);
		return "forward:../../view.jsp";
	}
}


