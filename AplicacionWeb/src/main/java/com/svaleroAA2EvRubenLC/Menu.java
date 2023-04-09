package com.svaleroAA2EvRubenLC;

import com.svaleroAA2EvRubenLC.util.Utils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
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
            String opcion=entrada.next();

            switch (opcion){
                case "1":
            }

        }while(!salir);

    }
}
