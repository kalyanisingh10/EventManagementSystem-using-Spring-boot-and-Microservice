package com.example.eventms.users.repository;

import com.example.eventms.users.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,Long> {

   // @Query("{'email' : ?0}")
    Users findUserByEmail(String email);
}
