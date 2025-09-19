package main;

import jugador.Jugador;
import tauler.Tauler;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Tauler n = new Tauler();
        Jugador player = new Jugador();
        int aux=0;
        boolean continuar=true;
        try {
            do {
                //System.out.println("Tens"+ player.getMoney()+"€");
                if (aux>0){
                    System.out.println("Vols parar de jugar?");
                    System.out.println("Introdueix un \"1\" si introdueixes cualsevol altre cosa seguiras jugant" );
                    continuar = (1==t.nextInt());
                }
                n.bet();
                aux++;
            }while(continuar);
        } catch (Exception e) {
            throw new RuntimeException();
        }




    }
}