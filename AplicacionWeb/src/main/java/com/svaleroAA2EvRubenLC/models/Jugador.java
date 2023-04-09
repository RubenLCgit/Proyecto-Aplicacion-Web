package com.svaleroAA2EvRubenLC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private String id_jugador_pk;
    private String nombre;
    private String apellidos;
    private LocalDate fecha_nac;
    private String telefono;
}
