package com.transport.dto;

import com.transport.entity.UserCred;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReturn {
    String username;
    String token;
    Integer role;

    public LoginReturn(UserCred user){
        this.username = user.getUsername();
        this.role = user.getFkRole();
    }
}
