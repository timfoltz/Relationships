package com.tim.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tim.relationships.models.Person;
import com.tim.relationships.services.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
//	******root******
	@GetMapping("/")
	private String index(Model model) {
		List<Person> people = personService.allPeople();
		model.addAttribute("people", people);
		return "index.jsp";
	}
//	******Create******
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "newPerson.jsp";
	}
	@PostMapping("/persons")
	public String create(@Valid @ModelAttribute("person")Person person, 
							BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}
	}
//	******READ******
//	------ALL------
//	******root******
	
	
//	------ONE------
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id")Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "showPerson.jsp";
	}
//	------SOME------
//	******Delete/Destroy******
	
}
