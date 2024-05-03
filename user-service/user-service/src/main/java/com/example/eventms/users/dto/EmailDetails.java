package com.example.eventms.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmailDetails {

    private String recipients;
    private String messageBody;
    private String subject;

}
