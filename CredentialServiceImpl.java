package com.itSupport.service;

import java.util.Random;

import com.itSupport.model.Employee;

public class CredentialServiceImpl implements CredentialService {

	@Override
	public String generateEmailAddress(String firstName, String lastName, String deptName, String company) {
		String generatedEmail = firstName + lastName + "@" + deptName +"."+ company + ".com";
		return generatedEmail;
	}

	private static final String UPP_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOW_CHAR = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARS = "@#!%$^&*-<)";
	private static final String PASSWORD_GEN = UPP_CHAR + LOW_CHAR + NUMBERS + SPECIAL_CHARS;
	private static final Random random = new Random();

	@Override
	public String generateCredentials(int maxLength) {

		StringBuilder passwordBuilder = new StringBuilder(maxLength);
		// at least one lower case
		passwordBuilder.append(LOW_CHAR.charAt(random.nextInt(LOW_CHAR.length())));

		// at least one upper case
		passwordBuilder.append(UPP_CHAR.charAt(random.nextInt(UPP_CHAR.length())));

		// at least one number case
		passwordBuilder.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

		// at least one special character case
		passwordBuilder.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

		// fill the rest of the password with random characters
		for (int i = 4; i < maxLength; i++) {
			passwordBuilder.append(PASSWORD_GEN.charAt(random.nextInt(PASSWORD_GEN.length())));
		}

		// shuffle the characters in the password
		char[] passwordChars = passwordBuilder.toString().toCharArray();
		for (int i = 0; i < passwordChars.length;) {
			// get a random char from the array
			int j = random.nextInt(passwordChars.length);
			// store the char in a random char variable
			char temp = passwordChars[j];
			// assigning character from the random number to the i variable of the array
			passwordChars[i] = passwordChars[j];
			// assigning temporary variable to passworChars
			passwordChars[j] = temp;

			return new String(passwordChars);
		}

		return null;
	}

	@Override
	public void displayCredentials(Employee employee) {
		System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows: ");
		System.out.println("Email-->\t" + employee.getEmail());
		System.out.println("Password-->\t" + employee.getPassword());

	}


}