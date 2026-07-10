package com.certificate.verification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certificate.verification.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
 Optional<Certificate>findByCertificateId(String certificateId);
}
