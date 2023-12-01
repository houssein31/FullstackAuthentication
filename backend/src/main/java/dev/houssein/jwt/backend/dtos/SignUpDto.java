package dev.houssein.jwt.backend.dtos;

public record SignUpDto (String firstName, String lastName, String username, char[] password) {

}
