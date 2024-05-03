package com.example.eventms.events.service;

import com.example.eventms.events.entity.EventEntity;
import com.example.eventms.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    protected EventRepository eventRepository;

    //CRUD operation for Events

    public EventEntity createEvent(EventEntity event){
        event.setEventId(UUID.randomUUID().toString().split("-")[0]);
        event.setEventTime(new Date().toInstant().toString());
       return eventRepository.save(event);
    }

    public Optional<EventEntity> fetchEventById(String eventId){
      return eventRepository.findById(eventId);
    }

    public EventEntity updateEventById(EventEntity event){
        return eventRepository.save(event);
    }

    public String deleteEventById(String id){
        eventRepository.deleteById(id);
        return "Event deleted successfully";
    }

    public List<EventEntity> getEventByCategory(String category){
        return eventRepository.fetchEventByCategory(category);
    }
}
