package com.example.eventms.security.repository;

import com.example.eventms.security.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRespository extends JpaRepository<UserCredentials,Integer> {
}
