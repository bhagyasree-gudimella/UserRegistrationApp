package com.lavaya.gudimella.service;

import java.sql.SQLException; 
import java.util.ArrayList;
import com.lavanya.gudimella.dao.PersonDao;
import com.lavanya.gudimella.model.Person;
import com.lavanya.gudimella.validations.PersonFormValidation;
import com.lavanya.gudimella.validations.PersonFormValidationException;

public class PersonServiceImpl implements PersonService {
	private PersonDao personDao;

	/**
	 * This method is used to add the person into the database
	 * @param person
	 * @throws PersonFormValidationException 
	 */
	@Override
	public void addPerson(Person person) {
		personDao = new PersonDao();
		try {
			personDao.addPerson(person);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to find the person from the database
	 * @param email_address
	 * @return boolean
	 */
	@Override
	public boolean findPerson(String email_address) {
		personDao = new PersonDao();
		try {
			if(personDao.findPerson(email_address)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is used to get all the persons list from the database
	 * @return personsList
	 */
	@Override
	public ArrayList<Person> getAllPersonsList() {
		personDao = new PersonDao();
		ArrayList<Person> personsList = new ArrayList<Person>();
		try {
			personsList = personDao.getAllPersonsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personsList;
	}
	
	/**
	 * This method is used to update the person in database
	 * @param person
	 */
	@Override
	public void updatePerson(Person person) {
		personDao = new PersonDao();
		try {
			personDao.updatePerson(person);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to delete the person from database
	 * @param email_address
	 */
	@Override
	public void deletePerson(String email_address) {
		personDao = new PersonDao();
		try {
			personDao.deletePerson(email_address);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to validate personal info page 
	 * @param first_name, middle_name, last_name, email_address, gender
	 * @throws PersonFormValidationException
	 */
	@Override
	public void validatePersonalInfo(String first_name, String middle_name, String last_name, String email_address) throws PersonFormValidationException {
		String result = null;
		
		//person form validations
		PersonFormValidation personFormValidation = new PersonFormValidation();
		result = personFormValidation.validatePersonalInfoForm(first_name, middle_name, last_name, email_address);
		
		//throw error if validation is not success
		if(result!=null) {
			// get the personFormValidationException
			PersonFormValidationException personFormValidationException = new PersonFormValidationException();
			personFormValidationException.setErrorMessage(result);
			throw personFormValidationException;
		}
	}

	/**
	 * This method is used to validate Contact info page 
	 * @param address, city, state, country, ZIPCODE, phone_number
	 * @throws PersonFormValidationException
	 */
	@Override
	public void validateContactInfo(String address, String city, String state, String country, String zipcode, String phone_number) throws PersonFormValidationException {
		String result = null;
		
		// person contact information form validation
		PersonFormValidation personFormValidation = new PersonFormValidation();
		result = personFormValidation.validateContactInfoForm(address, city, state, country, zipcode, phone_number);
		
		//throw error if validation is not success
		if(result!=null) {
			// get the personFormValidationException
			PersonFormValidationException personFormValidationException = new PersonFormValidationException();
			personFormValidationException.setErrorMessage(result);
			throw personFormValidationException;
		}
	}
	
	/**
	 * This method is used to validate the bank information form
	 * @param bank_name
	 * @param account_details
	 * @param ssn_number
	 */
	@Override
	public void validateBankInfo(String bank_name, String account_details, String ssn_number) throws PersonFormValidationException {
		String result = null;
		
		// person contact information form validation
		PersonFormValidation personFormValidation = new PersonFormValidation();
		result = personFormValidation.validateBankInfoForm(bank_name, account_details, ssn_number);
		
		//throw error if validation is not success
		if(result!=null) {
			// get the personFormValidationException
			PersonFormValidationException personFormValidationException = new PersonFormValidationException();
			personFormValidationException.setErrorMessage(result);
			throw personFormValidationException;
		}
	}
}