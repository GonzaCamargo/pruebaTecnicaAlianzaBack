package com.pruebaTecnicaAlianza.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nombreCliente;
    @Column
    private String telefonoCliente;
    @Column
    private String correoCliente;

    @Column
    private Date fechaInicioCliente;
    @Column
    private Date fechaFinCliente;


}
