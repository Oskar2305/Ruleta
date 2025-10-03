package main;

import jugador.Jugador;
import joc.Tauler;

import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Tauler n = new Tauler();
        Jugador player = new Jugador("Nombre ejemplo");
        boolean continuar=true;
        while(continuar){
            System.out.println("Tens "+ player.getMoney()+" €");
            try {
                n.bet(player);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Vols parar de jugar?");
            System.out.println("Introdueix un \"1\" si introdueixes cualsevol altre cosa seguiras jugant");
            int conf = t.nextInt();
            if (conf==1){
                continuar=false;
            }
        }
    }
}