package com.lavanya.gudimella.dao;

import java.sql.Connection;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.lavanya.gudimella.model.Person;

public class PersonDao {
	private DatabaseConnection databaseConnection;

	/**
	 * This method is used to insert the person object into
	 * MYSQL database
	 * @param person
	 * @return
	 * @throws SQLException
	 */
	public boolean addPerson(Person person) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "insert into Person(first_name, middle_name, last_name, email_address, gender, address, city, state, country, zipcode, phone_number, bank_name, account_details, ssn_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getFirst_name());
		preparedStatement.setString(2, person.getMiddle_name());
		preparedStatement.setString(3, person.getLast_name());
		preparedStatement.setString(4, person.getEmail_address());
		preparedStatement.setString(5, person.getGender());
		preparedStatement.setString(6, person.getAddress());
		preparedStatement.setString(7, person.getCity());
		preparedStatement.setString(8, person.getState());
		preparedStatement.setString(9, person.getCountry());
		preparedStatement.setString(10, person.getZipcode());
		preparedStatement.setString(11, person.getPhone_number());
		preparedStatement.setString(12, person.getBank_name());
		preparedStatement.setString(13, person.getAccount_details());
		preparedStatement.setString(14, person.getSsn_number());
		
		int result = preparedStatement.executeUpdate();
		if(result==1) {
			System.out.println("Person has been successfully registered");
			return true;
		}
		connection.close();
		return false;
	}
	
	/**
	 * This method is used to find the person exists in database or not
	 * @param email_address
	 * @return
	 * @throws SQLException
	 */
	public boolean findPerson(String email_address) throws SQLException {
		boolean contains_person = false;
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "select * from Person where email_address=?";
		
		PreparedStatement preparedStatment = connection.prepareStatement(query);
		preparedStatment.setString(1, email_address);
		ResultSet resultSet = preparedStatment.executeQuery();
		while(resultSet.next()) {
			String dbEmail = resultSet.getString(5);
			if(dbEmail.equals(email_address)) {
				contains_person = true;
			}
		}
		connection.close();
		return contains_person;
	}
	
	/**
	 * This method returns all the person entries from the 
	 * person database
	 * @return ArrayList<Person>
	 * @throws SQLException
	 */
	public ArrayList<Person> getAllPersonsList() throws SQLException {
		databaseConnection = new DatabaseConnection();
		ArrayList<Person> personsList = new ArrayList<Person>();
		Connection connection = databaseConnection.getDatabaseConnection();
		
		String query = "select * from Person";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			String first_name = resultSet.getString(2);
			String middle_name = resultSet.getString(3);
			String last_name = resultSet.getString(4);
			String email_address = resultSet.getString(5);
			String gender = resultSet.getString(6);
			String address = resultSet.getString(7);
			String city = resultSet.getString(8);
			String state = resultSet.getString(9);
			String country = resultSet.getString(10);
			String zipcode = resultSet.getString(11);
			String phone_number = resultSet.getString(12);
			String bank_name = resultSet.getString(13);
			String account_details = resultSet.getString(14);
			String ssn_number = resultSet.getString(15);
			
			Person person = new Person(first_name,middle_name, last_name, email_address,gender,address,city,state,country,zipcode,phone_number,bank_name,account_details,ssn_number);
			personsList.add(person);
		}
		connection.close();
		return personsList;
	}
	
	/**
	 * This method is used to update the person details 
	 * in person table of SQL database
	 * @param person
	 * @return
	 * @throws SQLException 
	 */
	public void updatePerson(Person person) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "update Person set address=?, city=?, state=?, country=?, zipcode=?, phone_number=?, bank_name=?, account_details=? where email_address=?";
	
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getAddress());
		preparedStatement.setString(2, person.getCity());
		preparedStatement.setString(3, person.getState());
		preparedStatement.setString(4, person.getCountry());
		preparedStatement.setString(5, person.getZipcode());
		preparedStatement.setString(6, person.getPhone_number());
		preparedStatement.setString(7, person.getBank_name());
		preparedStatement.setString(8, person.getAccount_details());
		preparedStatement.setString(9, person.getEmail_address());
		
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			System.out.println("Person details has been successfully updated");
		}
		connection.close();
	}
	
	/**
	 * This method is used to delete the Person from database
	 * @param person
	 * @throws SQLException
	 */
	public void deletePerson(String email_address) throws SQLException {
		databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getDatabaseConnection();
		String query = "delete from Person where email_address=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email_address);
		
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			System.out.println("Person has been successfully deleted");
		}
		connection.close();
	}
}
