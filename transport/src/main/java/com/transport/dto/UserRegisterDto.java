package com.transport.dto;

import com.transport.entity.User;
import com.transport.entity.UserCred;
import com.transport.repository.UserCredRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegisterDto {
    String username;
    String password;
    String name;
    String surname;
}