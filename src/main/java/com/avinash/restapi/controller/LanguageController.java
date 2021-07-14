package com.avinash.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.restapi.exception.ResourceNotFoundException;

import com.avinash.restapi.model.Language;
import com.avinash.restapi.repository.LanguageRepository;



@RestController
@RequestMapping("/api/v1/")
public class LanguageController {
	
	@Autowired
	private  LanguageRepository languageRepository;
	
;

	//get all employees
	@GetMapping("/language")
	public List<Language> getAllLanguages(){
		return languageRepository.findAll();
	}
	
	//create employee
	@PostMapping("/language")
	public Language createLanguage(@RequestBody Language language) {
		return languageRepository.save(language);
	}
	
	//get employee by id
	@GetMapping("/language/{id}")
	public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
		Language lang = languageRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with id: " + id));
		return ResponseEntity.ok(lang);
	}
	

	
	//delete employee rest api
	@DeleteMapping("/language/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLanguage(@PathVariable Long id){
		Language lang = languageRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with id: " + id));
		
		languageRepository.delete(lang);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
