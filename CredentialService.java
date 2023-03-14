package com.itSupport.service;

import com.itSupport.model.Employee;
public interface CredentialService {
	
	public String generateEmailAddress(String firstName,String lastName,String deptName,String company);
	public String generateCredentials(int maxLength);
	public void displayCredentials(Employee employee);

}