package com.example.mapper;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class MapStructTest {

    @Test
    public void 맵스트럭츠테스트() throws Exception{

        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .password("testPassword")
                .name("testName")
                .nickName("testNickName")
                .createDate(new Date())
                .build();

        // Entity -> DTO
        UserDTO resultDTO = UserMapper.INSTANCE.userEntityToDTO(userEntity);
        // DTO -> Entity
        UserEntity resultEntity = UserMapper.INSTANCE.userDTOToEntity(resultDTO);

        System.out.println(resultEntity);
        System.out.println(resultDTO);
    }
}
