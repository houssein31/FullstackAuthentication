package dev.houssein.jwt.backend.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "app_user")
public class User {

    @Id
    private String id; // Changed from Long to String for MongoDB ID

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;
}
