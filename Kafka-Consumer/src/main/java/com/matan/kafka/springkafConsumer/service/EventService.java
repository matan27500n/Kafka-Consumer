package com.matan.kafka.springkafConsumer.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafConsumer.repo.EventRepository;
import com.matan.kafka.springkafkaproducer.model.Event;

@Service
public class EventService {

	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}

	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

	public void deleteEvent(int reporterId) {
		eventRepository.deleteById(reporterId);
		System.out.println("deleted successfully");
	}

	public Event getOneEvent(int reporterId) {
		return eventRepository.findById(reporterId).get();
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
}
