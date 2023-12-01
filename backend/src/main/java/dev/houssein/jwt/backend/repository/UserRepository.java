package dev.houssein.jwt.backend.repository;

import dev.houssein.jwt.backend.entities.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
