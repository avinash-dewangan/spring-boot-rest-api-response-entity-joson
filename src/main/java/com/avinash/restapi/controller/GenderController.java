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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.restapi.exception.ResourceNotFoundException;
import com.avinash.restapi.model.Gender;
import com.avinash.restapi.repository.GenderRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class GenderController {

	@Autowired
	private  GenderRepository genderRepository;

	//get all employees
	@GetMapping("/gender")
	public List<Gender> getAllGenders(){
		return genderRepository.findAll();
	}
	
	//create employee
	@PostMapping("/gender")
	public Gender createGender(@RequestBody Gender gender) {
		return genderRepository.save(gender);
	}
	
	//get employee by id
	@GetMapping("/gender/{id}")
	public ResponseEntity<Gender> getGenderById(@PathVariable Long id) {
		Gender gender = genderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with id: " + id));
		return ResponseEntity.ok(gender);
	}
	

	
	// update employee
	@PutMapping("/gender")
	public Gender updateGenderById(@RequestBody Gender gender) {
		return genderRepository.save(gender);
	}
	
	//delete employee rest api
	@DeleteMapping("/gender/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteGender(@PathVariable Long id){
		Gender gender = genderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with id: " + id));
		
		genderRepository.delete(gender);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}