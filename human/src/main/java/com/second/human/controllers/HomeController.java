package com.second.human.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String Hello(@RequestParam(value="name", required = false ) String searchN,
						@RequestParam(value="last_name", required = false ) String searchL) {
		if(searchN == null) {
			return "Hello Human";
		}
		else {	
			return "Hello " + searchN + searchL ;
		}
	}
	

	
	
}


