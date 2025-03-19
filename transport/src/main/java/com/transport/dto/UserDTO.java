package com.transport.dto;

import com.transport.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    String username;
    String name;
    String surname;
    String token;
    Integer role;

    public UserDTO(User user){
        this.username = user.getIdUser();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
