package com.example.mapper;

import com.example.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class ModelUserMapperTest {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void 모델매퍼테스트() throws Exception {

        // Entity에는 Setter가 없기 때문에 ModelMapper는 밑의 방식으로 값을 넣어줄 수 있습니다.
        modelMapper.createTypeMap(UserDTO.class, UserEntity.class).setProvider(
                // Setter가 없는 클래스를 넣어줍니다.
                new Provider<UserEntity>() {
                    public UserEntity get(ProvisionRequest<UserEntity> request) {
                        // 변환할 클래스를 가져와서 Setter가 없는 클래스를 만듭니다.
                        UserDTO dto = UserDTO.class.cast(request.getSource());
                        return UserEntity.builder()
                                .id(1L)
                                .password(dto.getPassword())
                                .name(dto.getName())
                                .nickName(dto.getNickName())
                                .createDate(new Date())
                                .build();
                    }
                }
                );

        UserEntity userEntity = UserEntity.builder().id(1L)
                .password("testPassword")
                .name("testName")
                .nickName("testNickName")
                .createDate(new Date())
                .build();;

//        // Entity -> DTO
        UserDTO resultDTO = modelMapper.map(userEntity, UserDTO.class);
//        // DTO -> Entity, Setter가 없을 시 변환할 수 없음
        UserEntity resultEntity = modelMapper.map(resultDTO, UserEntity.class);

    }
}