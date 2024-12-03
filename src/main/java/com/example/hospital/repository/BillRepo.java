package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Long> {

}
