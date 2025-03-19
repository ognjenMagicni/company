package com.transport.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="stage")
@Data
@ToString
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStage;

    @Column(name="name")
    private String name;
}
