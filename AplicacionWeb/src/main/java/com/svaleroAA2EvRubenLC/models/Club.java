package com.svaleroAA2EvRubenLC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    private String id_club_pk;
    private String nom_club;
    private String nom_calle;
    private int num_calle;
    private String cp;
    private String hor_apert;
    private String hor_cierre;
}
