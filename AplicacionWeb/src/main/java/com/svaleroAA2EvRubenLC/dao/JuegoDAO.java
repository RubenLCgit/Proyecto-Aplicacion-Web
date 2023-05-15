package com.svaleroAA2EvRubenLC.dao;

import com.svaleroAA2EvRubenLC.models.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        //return statement.executeUpdate()!=0;//TODO NO FUNCIONA. SIEMPRE DEVUELVE "0" AUNQUE BORRE UN REGISTRO
    }

    public List<Juego> mostrarJuegos() throws SQLException {
        String sql = "SELECT * FROM JUEGOS ";
        PreparedStatement statement = conexion.prepareStatement(sql);
        return buscarJuegos(statement);
    }

    public List<Juego> filtrarJuegos(String condicion1, String condicion2) throws SQLException {
        String sql = "SELECT * FROM JUEGOS WHERE NOMBRE = ? OR TIPO = ?";//TODO NO FUNCIONA SI METO "WHERE" COMO UN PARAMETRO "?"
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1,condicion1);
        statement.setString(2,condicion2);
        return buscarJuegos(statement);
    }

    public void modificarJuego(int duracion, String nombre) throws SQLException {
        String sql = "UPDATE JUEGOS SET DURACION_MIN = ? WHERE NOMBRE = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1,duracion);
        statement.setString(2,nombre);
        statement.executeUpdate();
    }


    public boolean existeJuego(String nomJuego) throws SQLException {
        String sql = "SELECT ID_JUEGO FROM JUEGOS WHERE NOMBRE= ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nomJuego);
        ResultSet result = statement.executeQuery();
        return result.next();
    }

    private List<Juego> buscarJuegos(PreparedStatement statement) throws SQLException {
        ResultSet resulset = statement.executeQuery();// Resulset contiene un cursor de una base de datos. Variable u objeto que en base de datos almacena más de un valor.
        List<Juego>listaJuegos=new ArrayList<Juego>();
        while (resulset.next()){//Esto comprueba que haya datos una fila tras otra de la tabla seleccionada dentro del resulset.
            Juego juego= new Juego();
            juego.setId_jue_pk(resulset.getString("ID_JUEGO"));
            juego.setNombre(resulset.getString("NOMBRE"));
            juego.setMax_jug(resulset.getInt("MAX_JUGADORES"));
            juego.setDuracion_max(resulset.getInt("DURACION_MIN"));
            juego.setTipo(resulset.getString("TIPO"));
            listaJuegos.add(juego);
        }
        return listaJuegos;
    }

}
