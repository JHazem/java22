package com.second.ninjaGame.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	ArrayList<String> activities=new ArrayList();
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	

	@PostMapping("/farm")
	public String firstGold(HttpSession session) {
		if(session.getAttribute("number") == null) {
			session.setAttribute("number" , 0);
		}
		Integer number = (Integer) session.getAttribute("number");
		
		Random rand = new Random();
	
		number = 10 + rand.nextInt(10);
		int num=(Integer)session.getAttribute("number");
		num+=number;
		session.setAttribute("number",num);
		activities.add("You entered .." + number);
		System.out.print(activities);
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	
	@PostMapping("/cave")
	public String secGold(HttpSession session) {
		if(session.getAttribute("number") == null) {
			session.setAttribute("number" , 0);
		}
		Integer number = (Integer) session.getAttribute("number");
		
		Random rand = new Random();

		number =  5 + rand.nextInt(6);
		int num=(Integer)session.getAttribute("number");
		num+=number;
		session.setAttribute("number",num);
		activities.add("You entered .." + number);
		System.out.print(activities);
		session.setAttribute("activities", activities);
		return "redirect:/";
		
	}
	
	@PostMapping("/house")
	public String thirdGold(HttpSession session) {
		if(session.getAttribute("number")==null) {
			session.setAttribute("number", 0);
		}
		Integer number = (Integer) session.getAttribute("number");
		
		Random rand = new Random();

			number = 2 + rand.nextInt(4);
			int num=(Integer)session.getAttribute("number");
			num+=number;
			session.setAttribute("number",num);
			activities.add("You entered .." + number);
			System.out.print(activities);
			session.setAttribute("activities", activities);
			return "redirect:/";
	}
	
	@PostMapping("/casino")
	public String myGold(HttpSession session) {
		if(session.getAttribute("number")==null) {
			session.setAttribute("number", 0);
		}
		Integer number = (Integer) session.getAttribute("number");
		
		Random rand = new Random();
	
			number = rand.nextInt(50);
			int num=(Integer)session.getAttribute("number");
			num+=number;
			session.setAttribute("number",num);
			activities.add("You entered .." + number);
			System.out.print(activities);
			session.setAttribute("activities", activities);
			return "redirect:/";
	}
	
	
	
}
