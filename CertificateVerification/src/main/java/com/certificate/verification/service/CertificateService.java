package com.certificate.verification.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.certificate.verification.entity.Certificate;
import com.certificate.verification.repository.CertificateRepository;
@Service
public class CertificateService {
@Autowired
private CertificateRepository certificateRepository;
 public Certificate verifyCertificate(String certificateId) {
	 Optional<Certificate> certificate = certificateRepository.findByCertificateId(certificateId);
	 if(certificate.isPresent()) {
		 return certificate.get();
	 }
	 return null;
 }
}
