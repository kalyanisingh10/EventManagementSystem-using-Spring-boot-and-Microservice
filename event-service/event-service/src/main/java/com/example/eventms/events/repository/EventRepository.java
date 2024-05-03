package com.example.eventms.events.repository;

import com.example.eventms.events.entity.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<EventEntity,String> {

    @Query("{eventCategory: ?0}")
    public List<EventEntity> fetchEventByCategory(String category);
}
