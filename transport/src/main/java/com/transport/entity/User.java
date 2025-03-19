package com.transport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.transport.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user", schema = "transport")
public class User {

    @Id
    @Column(name = "idUser", length = 45)
    private String idUser;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "surname", length = 45)
    private String surname;

    public User(UserRegisterDto userDTO){
        this.idUser = userDTO.getUsername();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
    }

}
