package dev.houssein.jwt.backend.mappers;

import dev.houssein.jwt.backend.dtos.SignUpDto;
import dev.houssein.jwt.backend.dtos.UserDto;
import dev.houssein.jwt.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password",  ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
