package com.healthcare.healthcare_system.repository;

import com.healthcare.healthcare_system.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
