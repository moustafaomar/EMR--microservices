package com.demo.Sql;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "PATIENT")
public class Patient {
	public Patient(Long nationalID, Long recordNumber, String phoneNumber, Date dateOfBirth, String firstName, String lastName, String middleName, Boolean gender, String photo, String email, Double weight, Double height,Long nationalIDRel) {
		NationalID = nationalID;
		RecordNumber = recordNumber;
		PhoneNumber = phoneNumber;
		DateOfBirth = dateOfBirth;
		FirstName = firstName;
		LastName = lastName;
		MiddleName = middleName;
		Gender = gender;
		Photo = photo;
		Email = email;
		this.weight = weight;
		this.height = height;
		NationalIDRel = nationalIDRel;
	}

	public Patient() {

	}

	public Long getNationalID() {
		return NationalID;
	}

	public void setNationalID(Long nationalID) {
		NationalID = nationalID;
	}

	public Long getRecordNumber() {
		return RecordNumber;
	}

	public void setRecordNumber(Long recordNumber) {
		RecordNumber = recordNumber;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public Boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}


	@Id
	@Column(name = "NationalID")
	private Long NationalID;
	@Column(name = "RecordNumber")
	private Long RecordNumber;
	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	@Column(name = "DateOfBirth")
	private Date DateOfBirth;
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "MiddleName")
	private String MiddleName;
	@Column(name = "Gender")
	private Boolean Gender;
	@Column(name = "Photo")
	private String Photo;
	@Column(name = "Email")
	private String Email;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "height")
	private Double height;

	public Long getNationalIDRel() {
		return NationalIDRel;
	}

	public void setNationalIDRel(Long nationalIDRel) {
		NationalIDRel = nationalIDRel;
	}

	@Transient
	private Long NationalIDRel;
}
