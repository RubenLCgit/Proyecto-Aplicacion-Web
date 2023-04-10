package com.svaleroAA2EvRubenLC.dao;

import java.sql.Connection;

public class JuegoDAO {
    private Connection conexion; //Cualquier calse que utilice en sus metodo la conexión a la base de datos necesitará un atributo de tipo "Connection".

    public JuegoDAO(Connection conexion){
        this.conexion=conexion;
    }
}
