package com.example.eventms.users.controller;

import com.example.eventms.users.constants.UserConstants;
import com.example.eventms.users.dto.ResponseDTO;
import com.example.eventms.users.entity.UserEvents;
import com.example.eventms.users.entity.Users;
import com.example.eventms.users.service.UserEventService;
import com.example.eventms.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventService userEventService;

    //CRUD operation

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Users> fetchUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody @Valid Users userData){
        return  userService.addUsers(userData);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@RequestBody @Valid Users userUpdateData){
        return userService.modifyUserData(userUpdateData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.of(Optional.ofNullable(userService.findAllUsers()));

    }

    @GetMapping("/user-events/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserEvents>> getUserEvents(@PathVariable String email){
        return ResponseEntity.ok(userEventService.getEventsByUserEmail(email));
    }

    @PostMapping("/add-user-event")
    public ResponseEntity<ResponseDTO> addEventsByUser(@RequestBody UserEvents userEvents){
        return new ResponseEntity<>(ResponseDTO.builder().statusCode(HttpStatus.CREATED.toString()).statusMessage(UserConstants.EVENT_SAVED).build(),HttpStatus.OK);

    }
}
