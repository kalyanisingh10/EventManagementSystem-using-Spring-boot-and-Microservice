package com.example.eventms.events.controller;

import com.example.eventms.events.entity.EventEntity;
import com.example.eventms.events.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    protected EventService eventService;

    //CRUD operation API
    @PostMapping
    public ResponseEntity<EventEntity>createEvent(@RequestBody @Valid EventEntity eventRequest){
        return  ResponseEntity.ok(eventService.createEvent(eventRequest));
    }

    @GetMapping("eventById/{id}")
    public Optional<EventEntity> getEventById(@PathVariable String id){
        return  ResponseEntity.ok(eventService.fetchEventById(id)).getBody();
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<EventEntity>> getEventByCategory(@RequestParam String category){
        return ResponseEntity.ok(eventService.getEventByCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(String id){
        eventService.deleteEventById(id);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @PutMapping
    public ResponseEntity<EventEntity> updateEvent(@RequestBody @Valid EventEntity eventData){
        return ResponseEntity.ok(eventService.updateEventById(eventData));
    }

}
