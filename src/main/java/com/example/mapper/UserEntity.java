package com.example.mapper;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    private Long id;
    private String password;
    private String name;
    private String nickName;
    private Date createDate;

    @Builder
    private UserEntity(Long id, String password, String name,
               String nickName, Date createDate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.createDate = createDate;
    }
}