package com.healthcare.healthcare_system.service;

import com.healthcare.healthcare_system.entity.Patient;
import com.healthcare.healthcare_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
    public Patient getPatientById(Long id){
        return patientRepository.findById(id).orElse(null);
    }
    public Patient updatePatient(Long id, Patient patientDetails){
        Patient patient=patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setGender(patientDetails.getGender());
        patient.setPhone(patientDetails.getPhone());
        patient.setAddress(patientDetails.getAddress());

        return patientRepository.save(patient);
    }
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }


}
