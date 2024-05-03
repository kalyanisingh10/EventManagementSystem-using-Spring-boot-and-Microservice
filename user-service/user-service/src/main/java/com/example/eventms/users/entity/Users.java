package com.example.eventms.users.entity;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EUsers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    @Id
    private Long userId;

    @NotBlank(message = "First Name is mandatory")
    @Size(max=20)
    private String firstName;

    private String lastName;

    private String gender;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max=10)
    private String phoneNum;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message="Country is mandatory")
    private String country;
}
