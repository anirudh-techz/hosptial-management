package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
