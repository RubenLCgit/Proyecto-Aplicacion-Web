package com.svaleroAA2EvRubenLC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotación para utilizar en esta clase la librería de "lombok" que crea automáticamente Get/Set necesarios.
@AllArgsConstructor // Crea un constructor con todos los atributos.
@NoArgsConstructor // Crea un constructor vacío o por defecto.
public class Juego {
    private String id_juego_pk;
    private String nombre;
    private int max_jugadores;
    private String tipo;
    private int duracion_min;
}
