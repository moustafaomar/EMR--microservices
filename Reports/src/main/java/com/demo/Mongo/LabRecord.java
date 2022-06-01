package com.demo.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.Date;

@Document("LabRecord")
public class LabRecord {
	@Id
	private BigInteger id;
	@Field("ReportFile")
	private String ReportFile;
	@Field("TestResult")
	private String TestResult;
	@Field("TestResultValue")
	private Long TestResultValue;
	@Field("TestResultNormalMin")
	private Long TestResultNormalMin;
	@Field("TestResultNormalMax")
	private Long TestResultNormalMax;
	@Field("TestDescription")
	private String TestDescription;
	@Field("Date")
	private java.util.Date Date;

	private Patient patientObj;
	private BigInteger patient;

	public Patient getPatientObj() {
		return patientObj;
	}

	public void setPatientObj(Patient patientObj) {
		this.patientObj = patientObj;
	}

	public BigInteger getPatient() {
		return patient;
	}

	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}
//	public LabRecord(BigInteger id, String reportFile, String testResult, Long testResultValue, Long testResultNormalMin, Long testResultNormalMax, String testDescription, Date date) {
//		this.id = id;
//		ReportFile = reportFile;
//		TestResult = testResult;
//		TestResultValue = testResultValue;
//		TestResultNormalMin = testResultNormalMin;
//		TestResultNormalMax = testResultNormalMax;
//		TestDescription = testDescription;
//		Date = date;
//	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getReportFile() {
		return ReportFile;
	}

	public void setReportFile(String reportFile) {
		ReportFile = reportFile;
	}

	public String getTestResult() {
		return TestResult;
	}

	public void setTestResult(String testResult) {
		TestResult = testResult;
	}

	public Long getTestResultValue() {
		return TestResultValue;
	}

	public void setTestResultValue(Long testResultValue) {
		TestResultValue = testResultValue;
	}

	public Long getTestResultNormalMin() {
		return TestResultNormalMin;
	}

	public void setTestResultNormalMin(Long testResultNormalMin) {
		TestResultNormalMin = testResultNormalMin;
	}

	public Long getTestResultNormalMax() {
		return TestResultNormalMax;
	}

	public void setTestResultNormalMax(Long testResultNormalMax) {
		TestResultNormalMax = testResultNormalMax;
	}

	public String getTestDescription() {
		return TestDescription;
	}

	public void setTestDescription(String testDescription) {
		TestDescription = testDescription;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}
}
