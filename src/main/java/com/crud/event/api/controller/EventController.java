package com.crud.event.api.controller;


import com.crud.event.api.domain.event.Event;
import com.crud.event.api.domain.event.EventRequestDto;
import com.crud.event.api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequestDto eventDto) {
        Event event = this.eventService.createEvent(eventDto);
        return ResponseEntity.ok(event);

    }


}
