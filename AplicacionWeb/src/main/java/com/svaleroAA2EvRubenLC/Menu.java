package com.svaleroAA2EvRubenLC;

import com.svaleroAA2EvRubenLC.dao.Database;
import com.svaleroAA2EvRubenLC.dao.JuegoDAO;
import com.svaleroAA2EvRubenLC.models.Juego;
import com.svaleroAA2EvRubenLC.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Scanner entrada;
    private Database database;
    private Connection conexion;
    public Menu(){
        entrada = new Scanner(System.in);
        database = new Database();
        conexion = database.conectar();

    }
    public void mostrarMenuJuegos(){
        boolean salir = false;

        do {
            System.out.println("JUEGOS DE MESA");
            System.out.println("\n");
            System.out.println("1: Registrar Juego");
            System.out.println("2: Modificar Juego");
            System.out.println("3: Buscar Juego");
            System.out.println("4: Eliminar Juego");
            System.out.println("5: Salir");
            System.out.println("\n");
            System.out.print("Elige un opción: ");
            Scanner entrada = new Scanner(System.in);
            switch (Utils.comprobarEntrada(entrada.next(),1,5)){
                case "1":
                    menuRegistrarJuego();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    salir=true;
                    database.cerrarConexion();
                    break;
                default:
                    System.out.println("Opción no valida. Vuelve a intentarlo:");
            }

        }while(!salir);

    }

    private void menuRegistrarJuego(){
        System.out.print("Nombre del juego: ");
        String nombre = entrada.next();
        System.out.print("Número máximo de jugadores: ");
        int max_jug = Integer.parseInt(Utils.comprobarEntrada(entrada.next(),1,20));
        System.out.print("Tipo de juego: ");
        String tipo = entrada.next();
        System.out.print("Duración máxima del juego (minutos): ");
        int duracion_max = Integer.parseInt(Utils.comprobarEntrada(entrada.next(),1,5000));
        Juego juego = new Juego(nombre, max_jug,tipo,duracion_max);
        JuegoDAO juegoDAO = new JuegoDAO(conexion);
        try {
            juegoDAO.registrarJuego(juego);//Capturamos aqui la excepcion lanzada por el metodo registrarJuego. Tambien podriamos volver a lanzarla a otra clase superior donde se use el metodo menuRegistrarJuego y asi sucesivamente hasta que la capturemos.
            System.out.println("Juego registrado correctamente");
        }catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }
}
