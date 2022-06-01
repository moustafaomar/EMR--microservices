package com.demo.Mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.LabelView;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@EnableMongoRepositories
public class LabRecordController {

	@Autowired
	private LabRecordRepository labRecordRepository;
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/records")
	public List<LabRecord> findAllModels() {
		return labRecordRepository.findAll();
	}

	@GetMapping("/record/{id}")
	public ResponseEntity<LabRecord> findRecordById(@PathVariable(value = "id") BigInteger id) {
		Optional<LabRecord> record = labRecordRepository.findById(id);
		if (record.isPresent()) {
			return ResponseEntity.ok().body(record.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/record/patient/{id}")
	public ResponseEntity<List<LabRecord>> findRecordByNatId(@PathVariable(value = "id") BigInteger id) {
		List<LabRecord> record = labRecordRepository.findByPatient(id);
		return ResponseEntity.ok().body(record);
	}

	@PostMapping("/record/save")
	public LabRecord saveRecord(@RequestBody LabRecord record) {
		Patient p = patientRepository.findById(record.getPatient()).orElse(null);
		record.setPatientObj(p);
		return labRecordRepository.save(record);
	}
}