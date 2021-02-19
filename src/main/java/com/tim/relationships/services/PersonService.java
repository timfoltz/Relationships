package com.tim.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.relationships.models.Person;
import com.tim.relationships.repos.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo;
//	******Create******
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
//	******Read ONE******
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		return optionalPerson !=null ? optionalPerson.get() : null;
	}
//	******Read ALL******
	public List<Person> allPeople()	{
		return personRepo.findAll();
	}
//	******Read SOME******
	public List<Person> noLicense(){
		return personRepo.findByLicenseIsNull();
	}
//	******Update******
	public void updatePerson(Person person) {
		personRepo.save(person);
	}
//	******Destroy/Delete******
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
}
