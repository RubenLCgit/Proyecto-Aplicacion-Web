package com.svaleroAA2EvRubenLC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class Database {
    private Connection conexion;
    public Connection conectar(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SID","Alumno","1234");
            System.out.println("Conexión realizada");
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Driver no encontrado");
        }catch (SQLException ex2){
            ex2.printStackTrace();
            System.out.println("Fallo de Conexión");
        }
        return conexion;
    }
    public void cerrarConexion(){
        try{
            conexion.close();
            System.out.println("Dexconexión realizada");
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("Fallo en la desconexión");
        }
    }
}
