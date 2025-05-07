package com.linkedIn.user_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {

    private String name;
    private String email;
    private String password;
}
