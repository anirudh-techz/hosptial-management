package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}
