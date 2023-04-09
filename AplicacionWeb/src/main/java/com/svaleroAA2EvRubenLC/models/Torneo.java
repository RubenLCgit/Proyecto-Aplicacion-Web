package com.svaleroAA2EvRubenLC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Torneo {
    private String id_torneo_pk;
    private LocalDate fecha_torn;
    private String hora_init;
    private int num_plazas;
}
