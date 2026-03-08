package com.healthcare.healthcare_system.service;

import com.healthcare.healthcare_system.entity.MedicalRecord;
import com.healthcare.healthcare_system.entity.Patient;
import com.healthcare.healthcare_system.repository.MedicalServiceRepository;
import com.healthcare.healthcare_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    private MedicalServiceRepository medicalRecordRepository;
    private PatientRepository patientRepository;

    public MedicalRecordService(MedicalServiceRepository medicalServiceRepository, PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalServiceRepository;
        this.patientRepository=patientRepository;
    }
    public MedicalRecord createMedicalRecord(Long patientId, MedicalRecord record){
        Patient patient=patientRepository.findById(patientId).orElseThrow(()-> new RuntimeException("Patient not Found"));
        record.setPatient_id(patient.getId());
        return medicalRecordRepository.save(record);
    }
    // Get records by patient
    public List<MedicalRecord> getRecordsByPatient(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    // Delete record
    public void deleteRecord(Long recordId) {
        medicalRecordRepository.deleteById(recordId);
    }

}
