package com.transport.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "package", schema = "transport")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_package", nullable = false)
    private Integer idPackage;

    @Column(name="title")
    String title;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "width")
    private Integer width;

    @Column(name = "length")
    private Integer length;

    @Column(name = "city_start")
    private Integer cityStart;

    @Column(name = "city_end")
    private Integer cityEnd;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "price")
    private Float price;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "address_start", length = 200)
    private String addressStart;

    @Column(name = "address_end", length = 200)
    private String addressEnd;

    @Column(name="fk_user")
    private String fkUser;

    @Column(name="fk_driver")
    private String fkDriver;

    @Column(name="grade")
    private Integer grade;

    @Column(name="comment")
    private String comment;

}