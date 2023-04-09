package com.svaleroAA2EvRubenLC.util;

import java.util.Scanner;

public class Utils {

    public static void comprobarEntrada (String nuMenor, String nuMayor, String opcion){
        while (!opcion.matches("["+nuMenor+ "-"+nuMayor+"]")){
            Scanner entrada= new Scanner(System.in);
            System.out.println("No es una opción valida.");
            System.out.println(" ");
            System.out.print("Las opciones validas solo comprender valores entre el "+nuMenor+" y el "+nuMayor+": ");
            opcion=entrada.next();
        }
    }
}
