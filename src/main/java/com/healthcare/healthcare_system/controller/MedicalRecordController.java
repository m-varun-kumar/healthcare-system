package com.healthcare.healthcare_system.controller;
import com.healthcare.healthcare_system.entity.MedicalRecord;
import com.healthcare.healthcare_system.service.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {
    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    // Add medical record
    @PostMapping("/{patientId}")
    public MedicalRecord addRecord(@PathVariable Long patientId,
                                   @RequestBody MedicalRecord record) {

        return medicalRecordService.createMedicalRecord(patientId, record);
    }

    // Get medical records by patient
    @GetMapping("/{patientId}")
    public List<MedicalRecord> getRecords(@PathVariable Long patientId) {

        return medicalRecordService.getRecordsByPatient(patientId);
    }

    // Delete record
    @DeleteMapping("/{recordId}")
    public String deleteRecord(@PathVariable Long recordId) {

        medicalRecordService.deleteRecord(recordId);
        return "Record deleted successfully";
    }
}
