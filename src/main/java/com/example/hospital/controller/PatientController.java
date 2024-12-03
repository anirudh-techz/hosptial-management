package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.Patient;
import com.example.hospital.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService pservice;
	
	@GetMapping
	public List<Patient> getAllPatients(){
		return pservice.getAllPatients();
	}
	
	@GetMapping("/{id}")
	public Patient getUserById(@PathVariable long id) {
		return pservice.getPatientById(id);
	}
	
	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return pservice.createPatient(patient);
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@RequestBody Patient patient,@PathVariable long id) {
		return pservice.updatePatient(id,patient);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long id) {
	 pservice.deletePatient(id);
	}
}
