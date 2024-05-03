package com.example.eventms.events.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    private String eventId;

    @NotBlank(message = "Event name is mandatory")
    private String eventName;

    @NotBlank(message = "Event category is mandatory")
    private String eventCategory;

    @NotBlank(message = "Event description is mandatory")
    private String eventDescription;

    @NotBlank(message = "Event address is mandatory")
    private String eventAddress;


    private String eventTime;


}
