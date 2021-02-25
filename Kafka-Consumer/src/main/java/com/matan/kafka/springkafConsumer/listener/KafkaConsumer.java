package com.matan.kafka.springkafConsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafConsumer.model.Event;
import com.matan.kafka.springkafConsumer.service.EventService;

@Service
public class KafkaConsumer {

	private EventService eventService;

	public KafkaConsumer(EventService eventService) {
		this.eventService = eventService;
	}

	@KafkaListener(topics = "eventsConsumer", groupId = "group_id", containerFactory = "eventKafkaListenerFactory")
	public void consumeJson(Event event) {
		System.out.println("Consumed JSON Message: " + event);
		eventService.addEvent(event);
	}
}
