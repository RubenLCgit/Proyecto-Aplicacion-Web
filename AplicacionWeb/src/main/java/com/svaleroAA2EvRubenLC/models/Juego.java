package com.svaleroAA2EvRubenLC.models;

import lombok.*;

@Data // Anotación para utilizar en esta clase la librería de "lombok" que crea automáticamente Get/Set necesarios.
@RequiredArgsConstructor // Crea un constructor con todos los atributos que sean "notnull".
@NoArgsConstructor // Crea un constructor vacío o por defecto.
public class Juego {
    private String id_jue_pk;
    @NonNull
    private String nombre;
    @NonNull
    private int max_jug;
    @NonNull
    private String tipo;
    @NonNull
    private int duracion_max;
}
