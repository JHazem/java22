package com.second.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String counter(HttpSession session) {
		if(session.getAttribute("count")==null){
			session.setAttribute("count",0);
		}
			Integer count=(Integer) session.getAttribute("count");
			count++;
		session.setAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/double")
	public String countdouble(HttpSession session) {
		if(session.getAttribute("count") == null){
			session.setAttribute("count",0);
		}
			Integer count=(Integer) session.getAttribute("count");
			count +=2;
		session.setAttribute("count", count);
		return "double.jsp";
	}
	
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("count");
		return "index.jsp";
	}
	
}

