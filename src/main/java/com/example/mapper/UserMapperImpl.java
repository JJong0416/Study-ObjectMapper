package com.example.mapper;

import org.mapstruct.Builder;

import javax.annotation.Generated;
import java.util.Date;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-06-03T16:00:52+0900",
        comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDTOToEntity(UserDTO userDTO) {
        if (userDTO == null){
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( userDTO.getId() );
        userEntity.name( userDTO.getName() );
        userEntity.password( userDTO.getPassword() );

        return userEntity.build();
    }

    @Override
    public UserDTO userEntityToDTO(UserEntity userEntity) {
        if (userEntity == null){
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());

        return userDTO;
    }
}