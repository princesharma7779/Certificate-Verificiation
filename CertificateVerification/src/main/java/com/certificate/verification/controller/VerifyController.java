package com.certificate.verification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.certificate.verification.entity.Certificate;
import com.certificate.verification.service.CertificateService;

@Controller
public class VerifyController {
	@Autowired
	private CertificateService certificateService;
	
	@GetMapping("/")
	public String showVerifyPage() {
		return "verify";
	}
	@PostMapping("/verify")
	public String verifyCertificate(
			@RequestParam("certificateId")String certificateId
			, Model model) 
	{
		Certificate certificate = certificateService
				.verifyCertificate(certificateId);
		
		if(certificate != null)
		{
			model.addAttribute("certificate",certificate);
			return "result";
		}else {
			model.addAttribute("message","Certificate Not Found");
			return "result";
		}
	}
}
