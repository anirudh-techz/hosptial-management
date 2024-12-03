package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepo;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepo drepo;
	
	public List<Doctor> getAllDoctors() {
		return drepo.findAll();
	}

	public Doctor getDoctorById(long id) {
		return drepo.findById(id).orElse(null);
	}

	public Doctor createDoctor(Doctor doctor) {
		return drepo.save(doctor);
	}

	public Doctor updateDoctor(long id, Doctor doctor) {
		Doctor existingDoctor = getDoctorById(id);
	if (existingDoctor !=null) {
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSpeciality(doctor.getSpeciality());
		existingDoctor.setAvailability(doctor.getAvailability());
		return drepo.save(existingDoctor);
	}
	return null;
}

	public void deleteDoctor(long id) {
		drepo.deleteById(id);
		
	}

}
