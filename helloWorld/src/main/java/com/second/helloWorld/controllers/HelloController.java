package com.second.helloWorld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
 
}
