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

import com.example.hospital.entity.Appointment;
import com.example.hospital.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService aservice;
	

	@GetMapping
	public List<Appointment> getAllAppointments(){
		return aservice.getAllAppointments();
	}
	
	@GetMapping("/{id}")
	public Appointment getUserById(@PathVariable long id) {
		return aservice.getAppointmentById(id);
	}
	
	@PostMapping
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return aservice.createAppointment(appointment);
	}
	
	@PutMapping("/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment,@PathVariable long id) {
		return aservice.updateAppointment(id,appointment);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable long id) {
	 aservice.deleteAppointment(id);
}
}