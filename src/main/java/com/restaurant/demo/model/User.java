package com.restaurant.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "users")

@Builder
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;  // Hashed later
}
