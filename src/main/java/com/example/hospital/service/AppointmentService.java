package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Appointment;
import com.example.hospital.repository.AppointmentRepo;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo arepo;
	
	public List<Appointment> getAllAppointments() {
		return arepo.findAll();
	}

	public Appointment getAppointmentById(long id) {
		return arepo.findById(id).orElse(null);
	}

	public Appointment createAppointment(Appointment appointment) {
		return arepo.save(appointment);
	}

	public Appointment updateAppointment(long id,Appointment appointment) {
		Appointment existingAppointment = getAppointmentById(id);
	if (existingAppointment !=null) {
		existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
		existingAppointment.setDoctor(appointment.getDoctor());
		existingAppointment.setPatient(appointment.getPatient());
		existingAppointment.setStatus(appointment.getStatus());
		return arepo.save(existingAppointment);
	}
	return null;
}

	public void deleteAppointment(long id) {
		arepo.deleteById(id);
		
	}
}
