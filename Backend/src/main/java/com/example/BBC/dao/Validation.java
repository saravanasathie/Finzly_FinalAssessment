package com.example.BBC.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.example.BBC.exception.ValidationException;


public class Validation {

	public static void validateName(String name) throws ValidationException {
		if (name == null || name.isEmpty()) {
			throw new ValidationException("Name cannot be empty");
		}
	}

	public static void validateId(long Id) throws ValidationException { // customer Id is aadhar number
		// Aadhaar card number should be a 12-digit long value
		long minValidAadhar = 1000_0000_0000L; // 12-digit minimum value
		long maxValidAadhar = 9999_9999_9999L; // 12-digit maximum value
		if (!(Id >= minValidAadhar && Id <= maxValidAadhar)) {
			throw new ValidationException("Invalid id");

		}
	}

	public static void validateUnitConsumed(double unitConsumed) throws ValidationException {
		if (unitConsumed < 0) {
			throw new ValidationException("Unit consumed must be positive");
		}
	}

	public static void validateBillDates(Date billStartDate, Date billDueDate) throws ValidationException {
		if (billStartDate == null || billDueDate == null || billStartDate.after(billDueDate)) {
			throw new ValidationException("Invalid bill dates");
		}
	}

	public static void validateEmail(String email) throws ValidationException {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (!Pattern.matches(emailRegex, email)) {
			throw new ValidationException("Invalid email format");
		}
	}

	public static void validateTelephoneNumber(String telephoneNumber) throws ValidationException {

		String regex = "^[0-9]{10}$"; // Assumes a 10-digit format, adjust as needed
		if (!Pattern.matches(regex, telephoneNumber)) {
			throw new ValidationException("Invalid telephone number");
		}
	}

	public static void validateAddress(String address) {
		if (address == null || address.trim().isEmpty()) {
			throw new ValidationException("Address cannot be empty");
		}

		int minAddressLength = 4; // Adjust as needed
		int maxAddressLength = 100; // Adjust as needed
		if (address.length() < minAddressLength || address.length() > maxAddressLength) {
			throw new ValidationException("Address length should be between " + minAddressLength + " and "
					+ maxAddressLength + " characters.");
		}

		String validCharactersRegex = "^[a-zA-Z0-9\\s.,-]*$"; // Adjust as needed
		if (!Pattern.matches(validCharactersRegex, address)) {
			throw new ValidationException("Invalid characters in the address.");
		}

	}

	public static void validateRatePerKw(double ratePerKW) {
		if (ratePerKW < 0) {
			throw new ValidationException("Rate Per KW must be positive");
		}
	}

	public static void validateBillStatus(String billStatus) {
		if (billStatus == null || (!billStatus.equalsIgnoreCase("pending") && !billStatus.equalsIgnoreCase("paid"))) {
			throw new ValidationException("Invalid bill status. It must be either 'pending' or 'paid'.");
		}
	}

}