package com.example.BBC.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BBC.dao.OTPDao;
import com.example.BBC.entity.OTP;

@Service
public class OTPService {
	
	@Autowired
	private OTPDao otpDao;

	public  String generateOTP() {
		
		List<OTP> ListotpList=otpDao.generateOTP();
		Random random=new Random();
		int otpindex=random.nextInt(ListotpList.size());
		OTP selectedOtp= ListotpList.get(otpindex);
		return selectedOtp.getOtp();
		 
	}

	public String addOTP(OTP otp) {
		
		return otpDao.addOTP(otp);
	}
	
	
}