package com.demo.Mongo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {
	@Autowired
	private PatientRepository patientRepository;
	@KafkaListener(topics = "patient-created", groupId = KafkaConsumerConfig.GROUP_ID)
	public void listener(String patient) {
		Gson gson = new Gson();
		Patient p = gson.fromJson(patient,Patient.class);
		patientRepository.save(p);
	}

}
