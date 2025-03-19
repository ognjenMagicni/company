package com.transport.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.transport.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "driver", schema = "transport")
public class Driver {

    @Id
    @Column(name = "idDriver", length = 45)
    private String idDriver;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "surname", length = 45)
    private String surname;

    @Column(name = "dateStart")
    private Date dateStart;

    @Column(name = "fk_vehicle", length = 7)
    private String fkVehicle;

    @OneToMany(mappedBy = "fkDriver")
    private List<Package> packages;

    @OneToOne(mappedBy = "fkDriver")
    @JsonBackReference
    private Vehicle vehicle;

    public Driver(UserRegisterDto userDTO){
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.dateStart = new Date();
        this.idDriver = userDTO.getUsername();

    }

}
