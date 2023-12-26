package org.example.transport.mapper;

import org.example.model.User;
import org.example.transport.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToEntity(UserDTO dto);
    UserDTO entityToDto(User user);
}
