package com.itSupport.client;

import java.util.Scanner;

import com.itSupport.model.Employee;
import com.itSupport.service.CredentialServiceImpl;

public class Main {
	public static void main(String[] args) {
		Employee employee = new Employee("Aman", "Raj");
		employee.setCompany("WIPRO");
		CredentialServiceImpl serviceCredentials = new CredentialServiceImpl();
		System.out.println("Please enter the department from the following: ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		try (// Create the instance of scanner class
		Scanner myOption = new Scanner(System.in)) {
			int option = myOption.nextInt();

			switch (option) {
			case 1: {
				String generatedEmail = serviceCredentials.generateEmailAddress(employee.getFirstName().toLowerCase(),
						employee.getLastName().toLowerCase(), "tech", employee.getCompany().toLowerCase());
				String generatedPassword = serviceCredentials.generateCredentials(12);
				employee.setEmail(generatedEmail);
				employee.setPassword(generatedPassword);
				serviceCredentials.displayCredentials(employee);
				break;
			}
			case 2: {
				String generatedEmail = serviceCredentials.generateEmailAddress(employee.getFirstName().toLowerCase(),
						employee.getLastName().toLowerCase(),"admin", employee.getCompany().toLowerCase());
				String generatedPassword = serviceCredentials.generateCredentials(12);
				employee.setEmail(generatedEmail);
				employee.setPassword(generatedPassword);
				serviceCredentials.displayCredentials(employee);
				break;
			}
			case 3: {
				String generatedEmail = serviceCredentials.generateEmailAddress(employee.getFirstName().toLowerCase(),
						employee.getLastName().toLowerCase(), "hr", employee.getCompany().toLowerCase());
				String generatedPassword = serviceCredentials.generateCredentials(12);
				employee.setEmail(generatedEmail);
				employee.setPassword(generatedPassword);
				serviceCredentials.displayCredentials(employee);
				break;
			}
			case 4: {
				String generatedEmail = serviceCredentials.generateEmailAddress(employee.getFirstName().toLowerCase(),
						employee.getLastName().toLowerCase(), "legal", employee.getCompany().toLowerCase());
				String generatedPassword = serviceCredentials.generateCredentials(12);
				employee.setEmail(generatedEmail);
				employee.setPassword(generatedPassword);
				serviceCredentials.displayCredentials(employee);
				break;
			}
			default: {
				System.out.println("Enter a valid option");
				break;
			}

			}
		}

	}

}