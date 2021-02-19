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

import com.tim.relationships.models.License;
import com.tim.relationships.models.Person;
import com.tim.relationships.services.LicenseService;
import com.tim.relationships.services.PersonService;

@Controller
public class LicenseController {
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private PersonService personService;
////	******root******
//	@GetMapping("/")
//	private String index(Model model) {
//		List<License> licenses = licenseService.allLicenses();
//		model.addAttribute("licenses", licenses);
//		return "index.jsp";
//	}
//	******Create******
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")License license, Model model) {
		
		model.addAttribute("person",personService.noLicense());
		
		return "newLicense.jsp";
	}
	@PostMapping("/licenses")
	public String create(@Valid @ModelAttribute("license")License license, 
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("person",personService.noLicense());
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
//	******READ******
//	------ALL------
//	******root******
	
	
//	------ONE------
	@GetMapping("/licenses/{id}")
	public String showLicense(@PathVariable("id")Long id, Model model) {
		License license = licenseService.findLicense(id);
		model.addAttribute("license", license);
		return "showLicense.jsp";
	}
//	------SOME------
//	******Delete/Destroy******
}
