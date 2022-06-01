package com.demo.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document("Patient")
public class Patient {
	@Id
	private BigInteger nationalID;

	private String firstName;

	private String lastName;

	private String weight;

	private String height;

	public Patient(BigInteger nationalID, String firstName, String lastName, String weight, String height) {
		this.nationalID = nationalID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
	}

	public BigInteger getNationalID() {
		return nationalID;
	}

	public void setNationalID(BigInteger nationalID) {
		this.nationalID = nationalID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
}
