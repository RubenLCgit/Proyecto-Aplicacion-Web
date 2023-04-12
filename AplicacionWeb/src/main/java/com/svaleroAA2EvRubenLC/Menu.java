package com.svaleroAA2EvRubenLC;

import com.svaleroAA2EvRubenLC.dao.Database;
import com.svaleroAA2EvRubenLC.dao.JuegoDAO;
import com.svaleroAA2EvRubenLC.models.Juego;
import com.svaleroAA2EvRubenLC.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
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
            System.out.println("5: Mostrar todos los juegos");
            System.out.println("6: Salir");
            System.out.println("\n");
            System.out.print("Elige un opción: ");
            Scanner entrada = new Scanner(System.in);
            switch (Utils.comprobarEntrada(entrada.next(),1,5)){
                case "1":
                    menuRegistrarJuego();
                    break;
                case "2":
                    menuModificarJuego();
                    break;
                case "3":
                    menuBuscarJuego();
                    break;
                case "4":
                    menuBorrarJuego();
                    break;
                case "5":
                    menuMostrarJuegos();
                    break;
                case "6":
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
            juegoDAO.registrarJuego(juego);//Capturamos aqui la excepción lanzada por el método registrarJuego. También podríamos volver a lanzarla a otra clase superior donde se use el metodo menuRegistrarJuego y asi sucesivamente hasta que la capturemos.
            System.out.println("Juego registrado correctamente");
        }catch (SQLException sqle){
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }

    private void menuBorrarJuego(){
        System.out.print("Nombre del juego a borrar: ");
        String nombre = entrada.next();
        JuegoDAO juegoDAO = new JuegoDAO(conexion);
        try {//Capturamos aqui la excepcion lanzada por el metodo registrarJuego. Tambien podriamos volver a lanzarla a otra clase superior donde se use el metodo menuRegistrarJuego y asi sucesivamente hasta que la capturemos.
            if (!juegoDAO.existeJuego(nombre))System.out.println("El juego no esta registrado");
            else {
                juegoDAO.borrarJuego(nombre);
                System.out.println("Juego borrado correctamente");
            }
        }catch (SQLException sqle){
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }

    private void menuMostrarJuegos(){
        JuegoDAO juegoDAO = new JuegoDAO(conexion);
        try{
            if (!juegoDAO.mostrarJuegos().isEmpty())
                for (int i=0;i<juegoDAO.mostrarJuegos().size();i++){
                    System.out.println(juegoDAO.mostrarJuegos().get(i));
                }
            else System.out.println("No hay datos registrados");
        }catch (SQLException sqle){
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }

    private void menuBuscarJuego(){
        JuegoDAO juegoDAO = new JuegoDAO(conexion);
        System.out.print("Nombre del juego que quieres buscar (0 para ningún valor): ");
        String condicion1 = entrada.nextLine();
        System.out.print("Y/O Tipo de juego a buscar (0 para ningún valor): ");
        String condicion2 = entrada.nextLine();
        try{
            if (!juegoDAO.filtrarJuegos(condicion1,condicion2).isEmpty())
                for (int i=0;i<juegoDAO.filtrarJuegos(condicion1,condicion2).size();i++){
                    System.out.println(juegoDAO.filtrarJuegos(condicion1,condicion2).get(i));
                }
            else System.out.println("Juegos no encontrados");
        }catch(SQLException sqle){
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }

    private void menuModificarJuego() {
        JuegoDAO juegoDAO = new JuegoDAO(conexion);
        System.out.print("Nombre del juego que quieres modificar: ");
        String nombre = entrada.nextLine();
        System.out.print("Especifica la duración maxima del juego: ");
        int duracion = Integer.parseInt(entrada.nextLine());
        try {
            if (!juegoDAO.existeJuego(nombre))System.out.println("El juego no esta registrado");
            else {
                juegoDAO.modificarJuego(duracion, nombre);
                System.out.println("Juego modificado");}
        } catch (SQLException sqle) {
            System.out.println("Fallo de Conexión con la base de datos");
        }
    }
}
