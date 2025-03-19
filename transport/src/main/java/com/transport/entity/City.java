package com.transport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "city", schema = "transport")
public class City {

    @Id
    @Column(name = "id_city")
    private Integer idCity;

    @Column(name = "name")
    private String name;

}
