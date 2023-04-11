package com.svaleroAA2EvRubenLC.dao;

import com.svaleroAA2EvRubenLC.models.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JuegoDAO {
    private Connection conexion; //Cualquier calse que utilice en sus metodo la conexión a la base de datos necesitará un atributo de tipo "Connection".
    Scanner entrada=new Scanner(System.in);

    public JuegoDAO(Connection conexion){
        this.conexion=conexion;
    }

    public void registrarJuego(Juego juego) throws SQLException {// Lanza la excepcion a una clase superior que utilice este metodo llamado "registrarJuego"
        String sql = "INSERT INTO JUEGOS(NOMBRE, MAX_JUGADORES, DURACION_MIN, TIPO) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1,juego.getNombre());
        statement.setInt(2,juego.getMax_jug());
        statement.setInt(3,juego.getDuracion_max());
        statement.setString(4,juego.getTipo());
        statement.executeUpdate();//executeQuery : para selects // executeUpdate() : para el resto de sentencias
    }

    public void borrarJuego(String nombre) throws SQLException {
        String sql = "DELETE FROM JUEGOS WHERE NOMBRE= ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1,nombre);
        statement.executeUpdate();
    }

}
