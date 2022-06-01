package com.demo.Sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/patients")
	public List<Patient> findAllModels() {
		return patientRepository.findAll();
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> findPatientById(@PathVariable(value = "id") long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			return ResponseEntity.ok().body(patient.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/patient/save")
	public Patient savePatient(@RequestBody Patient patient) {
		MessageProducer.produce(patient);
		return patientRepository.save(patient);
	}
}