package dev.houssein.jwt.backend.controllers;

import dev.houssein.jwt.backend.config.UserAuthenticationProvider;
import dev.houssein.jwt.backend.dtos.CredentialsDto;
import dev.houssein.jwt.backend.dtos.SignUpDto;
import dev.houssein.jwt.backend.dtos.UserDto;
import dev.houssein.jwt.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {

        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthenticationProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);
        user.setToken(userAuthenticationProvider.createToken(user));
        return  ResponseEntity.created(URI.create("/users/" +  user.getId())).body(user);
    }
}
