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

	@KafkaListener(topics = "Kafka_Json", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(Event event) {
		System.out.println("Consumed JSON Message: " + event);
		eventRepository.save(event);
	}
}
