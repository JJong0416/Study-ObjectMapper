package com.example.mapper;

import org.mapstruct.factory.Mappers;

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userDTOToEntity(UserDTO userDTO);

    UserDTO userEntityToDTO(UserEntity userEntity);
}
