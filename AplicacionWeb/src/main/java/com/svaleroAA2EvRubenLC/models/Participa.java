package com.svaleroAA2EvRubenLC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participa {
    private String id_jugador_fk;
    private String id_torneo_fk;
}
