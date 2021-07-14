package com.avinash.restapi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avinash.restapi.model.Login;

@Controller
@RequestMapping("/myapp")
public class MyController {

	private ArrayList<Object> arrayList;

	@RequestMapping(value = "/about", method = RequestMethod.GET )
	public String about(Model model) {
		System.out.println("about");
		
		model.addAttribute("name", "avinash");
		model.addAttribute("currentdate", new Date().toString());
		
		return "about";

	}
	
	@GetMapping("/example-loop")
	public String iteraterHandler(Model m) {
		
		arrayList = new ArrayList<>();
		
		arrayList.add("ravi");
		arrayList.add("kavi");
		arrayList.add("javi");
		m.addAttribute("names",arrayList);
		return "itr";
	}
	
	//Handler for condtional statements
	@GetMapping("condtional")
	public String condtionalHandler(Model m) {
		
		m.addAttribute("isActive", true);
	    m.addAttribute("gender","F");
	    
	    List<Integer> mylist = new ArrayList<>();
		  mylist.add(20);
		  mylist.add(20);
		  mylist.add(20);
		  mylist.add(20);
		  m.addAttribute("list",mylist);  
		  
		return "condtional";
	}
	
	//handler of including fragment
	@GetMapping("/fragment")
	public String fragment(Model m) {
		m.addAttribute("title", "I Like to eat samosha");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "fragment";
	}
	
	// for new about
	@GetMapping("/newAbout")
	public String newAbout() {
		
		return "about-new";
	}
	
	// for new contact
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	//open login form
	@GetMapping("/form")
	public String openForm(Model m) {
		
		m.addAttribute("login", new Login());
		
		return "form/form";
	}
	
	//handler processing fomr
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("login") Login login, BindingResult result) {
		System.out.println(login);
		if(result.hasErrors()) {
			System.out.println(result);
			return "form/form";
		}
		System.out.println(login);
		return "form/success";
	}
	
}
