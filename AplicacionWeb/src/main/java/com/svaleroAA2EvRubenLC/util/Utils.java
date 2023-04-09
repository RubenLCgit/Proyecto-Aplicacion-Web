package com.svaleroAA2EvRubenLC.util;

import java.util.Scanner;

public class Utils {

    public static void comprobarEntrada (String nuMenor, String nuMayor, String opcion){
        while (!opcion.matches("["+nuMenor+ "-"+nuMayor+"]")){
            Scanner entrada= new Scanner(System.in);
            System.out.println("No es una opción valida.");
            System.out.println(" ");
            System.out.println("Introduce un número del "+nuMenor+" al "+nuMayor);
            opcion=entrada.next();
        }
    }
}
