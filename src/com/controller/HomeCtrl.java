package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Spitter;
import com.repository.SpitterRepository;
import com.repository.SpittlRepository;

@Controller
public class HomeCtrl {
	@Autowired
	private SpittlRepository repository;
	@Autowired
	private SpitterRepository spitterRepository;
	
	public HomeCtrl() {
	}

	public HomeCtrl(SpittlRepository repository) {
		this.repository=repository;
	}

	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/spittles")
	@ModelAttribute(value="mydatas")
	public String getSpittles(Model model){
		model.addAttribute(repository.findSpittles(2,5));
		return "mypage";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processReg(@Valid Spitter spitter,Errors errors){
		if(errors.hasErrors()){
			System.out.println("has errors");
			return "registerForm";
		}
		
		spitterRepository.save(spitter);
		System.out.println("redirect to spitter user page");
		return "redirect:/spitter/"+spitter.getUsername();
	}

	public SpittlRepository getRepository() {
		return repository;
	}

	public void setRepository(SpittlRepository repository) {
		this.repository = repository;
	}

	public SpitterRepository getSpitterRepository() {
		return spitterRepository;
	}

	public void setSpitterRepository(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
}
