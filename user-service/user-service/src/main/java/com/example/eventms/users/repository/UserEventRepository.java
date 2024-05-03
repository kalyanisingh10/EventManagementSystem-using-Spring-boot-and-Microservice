package com.example.eventms.users.repository;


import com.example.eventms.users.entity.UserEvents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventRepository extends MongoRepository<UserEvents,String> {

    @Query("{userEmail:'?0'}")
    List<UserEvents> findAllEventsByEmail(String userEmail);

}
