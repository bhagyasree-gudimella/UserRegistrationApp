package com.lavaya.gudimella.service;

import java.util.ArrayList;

import com.lavanya.gudimella.model.Person;
import com.lavanya.gudimella.validations.PersonFormValidationException;

public interface PersonService {
	public void addPerson(Person person);
	
	public boolean findPerson(String email_address);
	
	public ArrayList<Person> getAllPersonsList();
	
	public void validatePersonalInfo(String first_name, String middle_name, String last_name, String email_address) throws PersonFormValidationException;
	
	public void validateContactInfo(String address, String city, String state, String country, String zipcode, String phone_number) throws PersonFormValidationException;
	
	public void validateBankInfo(String bank_name, String account_details, String ssn_number) throws PersonFormValidationException;
	
	public void updatePerson(Person person);
	
	public void deletePerson(String email_address);
}
