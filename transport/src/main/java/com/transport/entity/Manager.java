package com.transport.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "manager", schema = "transport")
public class Manager {

    @Id
    @Column(name = "id_manager", length = 45)
    private String idManager;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "surname", length = 45)
    private String surname;

    @Column(name = "date_start")
    private Date dateStart;

}
