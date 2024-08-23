package com.sparta.membertest.dto;

import lombok.Getter;

@Getter
public class MemberDetailsResponseDto {
    private final Long id;
    private final String name;

    public MemberDetailsResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
