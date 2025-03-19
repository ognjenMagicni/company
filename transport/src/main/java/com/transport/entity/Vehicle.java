package com.transport.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "vehicle", schema = "transport")
public class Vehicle {

    @Id
    @Column(name = "id_vehicle", length = 7, nullable = false)
    private String idVehicle;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_driver")
    @JsonManagedReference
    private Driver fkDriver;

    @Column(name = "registration_start")
    @Temporal(TemporalType.DATE)
    private Date registrationStart;

    @Column(name = "registration_end")
    @Temporal(TemporalType.DATE)
    private Date registrationEnd;

    @Column(name = "year")
    private Integer year;

    @Column(name = "boot")
    private Integer boot;

    @Column(name = "km")
    private Integer km;

    @Column(name = "date_small_service_last")
    private Date dateSmallServiceLast;

    @Column(name = "date_big_service_last")
    private Date dateBigServiceLast;

    @Column(name="image_path")
    private String imagePath;

}
