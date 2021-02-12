package com.matan.kafka.springkafConsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafConsumer.model.Event;
import com.matan.kafka.springkafConsumer.repo.EventRepository;

@Service
public class KafkaConsumer {

	private EventRepository eventRepository;

	public KafkaConsumer(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@KafkaListener(topics = "Kafka_Example", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}

	@KafkaListener(topics = "Kafka_Example_json2", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(Event event) {
		System.out.println("Consumed JSON Message: " + event);
		eventRepository.save(event);
	}
}
