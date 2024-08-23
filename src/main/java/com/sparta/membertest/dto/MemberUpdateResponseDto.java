package com.sparta.membertest.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponseDto {

    private Long id;
    private String name;

    public MemberUpdateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
