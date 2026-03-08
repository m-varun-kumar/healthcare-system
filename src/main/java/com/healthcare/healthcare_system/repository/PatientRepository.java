package com.healthcare.healthcare_system.repository;

import com.healthcare.healthcare_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
