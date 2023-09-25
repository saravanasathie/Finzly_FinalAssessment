package com.example.BBC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BBC.entity.OTP;
import com.example.BBC.service.OTPService;

@CrossOrigin()
@RestController
public class OTP_Controller {
	@Autowired
	private OTPService otpService;
	
	@GetMapping("getOTP")
	public String generateOTP(){
		return otpService.generateOTP();
	}
	
	@PostMapping("addOTP")
	public String addOTP(@RequestBody OTP otp) {
		return otpService.addOTP(otp);
	}

}