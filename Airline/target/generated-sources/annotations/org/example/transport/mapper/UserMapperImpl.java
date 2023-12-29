package org.example.transport.mapper;

import javax.annotation.processing.Generated;
import org.example.model.User;
import org.example.transport.dto.UserDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-28T17:12:49+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User dtoToEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    @Override
    public UserDTO entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( user.getUsername() );
        userDTO.password( user.getPassword() );

        return userDTO.build();
    }
}
