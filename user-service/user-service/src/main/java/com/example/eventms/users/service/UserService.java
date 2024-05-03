package com.example.eventms.users.service;


import com.example.eventms.users.constants.UserConstants;
import com.example.eventms.users.dto.EmailDetails;
import com.example.eventms.users.entity.Users;
import com.example.eventms.users.exception.UserAlreadyExistException;
import com.example.eventms.users.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.registration.name}")
    private String queues;

    @Value("${rabbitmq.exchange.registration.name}")
    private String registrationExchange;

    @Value("${rabbitmq.binding.registration.name}")
    private String registrationRoutingKey;

    //CRUD operation for Users

    public Users addUsers(Users users){
        //Before creation first need to check user is already exist or not
        if (userRepository.findUserByEmail(users.getEmail())!=null) {
         throw new UserAlreadyExistException(UserConstants.USER_ALREADY_EXIST);

        }else{
            users.setUserId(UUID.randomUUID().getMostSignificantBits());
        log.info("Starting sending mail");
            rabbitTemplate.convertAndSend(registrationExchange,registrationRoutingKey,EmailDetails.builder().messageBody("Registration successful with email id "+users.getEmail()).recipients(users.getEmail()).subject("REGISTRATION SUCCESS").build());
        log.info("End of sending email");
        }



        return userRepository.save(users);
    }

    public Users modifyUserData(Users users){
        return userRepository.save(users);
    }

    public Optional<Users> findUserById(Long id){
        return userRepository.findById(id);

    }

    public String deleteUser(Long id){
         userRepository.deleteById(id);
         return "User deletion successful";
    }

    public List<Users> findAllUsers(){
       return userRepository.findAll();
    }
}
