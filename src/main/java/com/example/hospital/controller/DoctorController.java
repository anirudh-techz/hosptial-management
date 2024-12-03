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

import com.example.hospital.entity.Doctor;
import com.example.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService dservice;
	
	@GetMapping
	public List<Doctor> getAllDoctors(){
		return dservice.getAllDoctors();
	}
	
	@GetMapping("/{id}")
	public Doctor getUserById(@PathVariable long id) {
		return dservice.getDoctorById(id);
	}
	
	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return dservice.createDoctor(doctor);
	}
	
	@PutMapping("/{id}")
	public Doctor updatePatient(@RequestBody Doctor doctor,@PathVariable long id) {
		return dservice.updateDoctor(id,doctor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable long id) {
	 dservice.deleteDoctor(id);
	}
}
