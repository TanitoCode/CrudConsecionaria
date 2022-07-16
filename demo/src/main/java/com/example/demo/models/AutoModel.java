package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="auto")
public class AutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String marca;
    private String modelo;
    private String color;
    private Double km;
    private String anio;
    private Double precio;
    private String foto;

}
