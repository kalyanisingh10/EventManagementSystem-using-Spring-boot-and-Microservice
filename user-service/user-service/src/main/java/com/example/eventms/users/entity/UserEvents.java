package com.example.eventms.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserEvents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEvents {

    @Id
    private String recordId;
    private String userEmail;
    private String eventId;
    private String eventCategory;
    private String eventName;
    private String status;
}
