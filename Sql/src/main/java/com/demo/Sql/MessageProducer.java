package com.demo.Sql;

import com.demo.Sql.Patient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Properties;

public class MessageProducer {
	public static int produce(Patient model) {
		// change Ip to TA machine IP
		String bootstrapServer = "kafka:9092";

		// create properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

		// create producer
		KafkaProducer<String, Patient> producer = new KafkaProducer<String, Patient>(properties);

		//create a producer record
		ProducerRecord<String, Patient> record = new ProducerRecord<String, Patient>(
				"patient-created", model);

		try {
			// send data
			producer.send(record);
			//flush data
			producer.flush();
			//flush and close producer
			producer.close();
			return 200;
		} catch (Exception e) {
			return 404;
		}

	}
}
