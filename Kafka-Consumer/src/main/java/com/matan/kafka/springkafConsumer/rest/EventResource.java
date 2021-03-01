package com.matan.kafka.springkafConsumer.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matan.kafka.springkafConsumer.service.EventService;
import com.matan.kafka.springkafkaproducer.model.Event;

@RestController
@RequestMapping("mongo")
public class EventResource {

	private EventService eventService;

	public EventResource(EventService eventService) {
		this.eventService = eventService;
	}

	@PostMapping("addEvent")
	public ResponseEntity<?> addEvent(@RequestBody Event event) {
		return new ResponseEntity<Event>(eventService.addEvent(event), HttpStatus.CREATED);
	}

	@PutMapping("updateEvent")
	public ResponseEntity<?> updateEvent(@RequestBody Event event) {
		return new ResponseEntity<Event>(eventService.updateEvent(event), HttpStatus.OK);
	}

	@DeleteMapping("deleteEvent/{reporterId}")
	public ResponseEntity<?> deleteEvent(@PathVariable int reporterId) {
		return new ResponseEntity<String>(eventService.deleteEvent(reporterId), HttpStatus.NO_CONTENT);
	}

	@GetMapping("getOneEvent/{reporterId}")
	public ResponseEntity<?> getOneEvent(@PathVariable int reporterId) {
		return new ResponseEntity<Event>(eventService.getOneEvent(reporterId), HttpStatus.OK);
	}

	@GetMapping("getAllEvents")
	public ResponseEntity<?> getAllEvents() {
		return new ResponseEntity<List<Event>>(eventService.getAllEvents(), HttpStatus.OK);
	}
}
