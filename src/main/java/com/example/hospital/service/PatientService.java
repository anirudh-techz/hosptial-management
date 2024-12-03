package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo prepo;

	public List<Patient> getAllPatients() {
		return prepo.findAll();
	}

	public Patient getPatientById(long id) {
		return prepo.findById(id).orElse(null);
	}

	public Patient createPatient(Patient patient) {
		return prepo.save(patient);
	}

	public Patient updatePatient(long id, Patient patient) {
	Patient existingPatient = getPatientById(id);
	if (existingPatient !=null) {
		existingPatient.setName(patient.getName());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setAge(patient.getAge());
		existingPatient.setMedicalavailability(patient.getMedicalavailability());
		return prepo.save(existingPatient);
	}
	return null;
}

	public void deletePatient(long id) {
		prepo.deleteById(id);
		
	}
}
