package com.example.eventms.users.service;

import com.example.eventms.users.entity.UserEvents;
import com.example.eventms.users.repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserEventService {

    @Autowired
    private UserEventRepository userEventRepository;

    //CRUD method for users and their events

    public List<UserEvents> getEventsByUserEmail(String email){
        return userEventRepository.findAllEventsByEmail(email);
       // userEventRepository.findAll()
    }

    public String saveUserEvent(UserEvents userEvents){
        userEvents.setRecordId(UUID.randomUUID().toString().split("-")[0]);
         userEventRepository.save(userEvents);
         return "Event saved successfully";

    }

}
