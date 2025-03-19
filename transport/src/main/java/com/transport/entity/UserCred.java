package com.transport.entity;

import com.transport.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Entity
@NoArgsConstructor
@Table(name="userCred")
public class UserCred {

    @Id
    @Column(name="username")
    String username;

    @Column(name="password")
    String password;

    @Column(name="fk_role")
    Integer fkRole;

    public UserCred(UserRegisterDto userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
    }

    public void setByUserRegisterDTO(UserRegisterDto userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.fkRole = 1;
    }
}
