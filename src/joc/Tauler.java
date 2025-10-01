package joc;

import jugador.Jugador;
import joc.Jugades;

import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static joc.Jugades.*;

public class Tauler {

    private final Random r = new Random();
    Jugador player = new Jugador("Nombre ejemplo");
    private final Casella[] caselles;

    public Tauler() {
        this.caselles = new Casella[37];
        // El 0 es VERD
        this.caselles[0] = new Casella(0, Color.VERD);

        // Números rojos estándar de la ruleta europea
        int[] vermell = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

        for (int i = 1; i <= 36; i++) {
            Color color;
            boolean esVermell = false;
            for (int v : vermell) {
                if (i == v) {
                    esVermell = true;
                    break;
                }
            }
            color = esVermell ? Color.VERMELL : Color.NEGRE;
            this.caselles[i] = new Casella(i, color);
        }
    }

    public Casella[] getCaselles() {
        return caselles;
    }

    /*Metode utilitzat al main per jugar*/
    public void bet() {
        Scanner n = new Scanner(System.in);
        int selectOpcio = 0;
        int aux = 0;
        do {
            if (aux > 0) {
                System.out.println("introdueix un valor VALID (entre 1-5) no es tan complicao tio, te has equivocado " + aux + "vez/es");
            }
            System.out.println("Digues a que apostes introduint un d'aquests numeros");
            System.out.println("1. A número");
            System.out.println("2. A dotzena");
            System.out.println("3. A color");
            System.out.println("4. A menor o major");
            System.out.println("5. A parell o imparell");
            try{
                selectOpcio = n.nextInt();
            }catch (InputMismatchException e){
                JOptionPane.showMessageDialog(null, "Error, has d'introduir un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }

            aux++;
        } while (selectOpcio > 5 || selectOpcio <= 0);

        /*Quantitat ha apostar*/

        double quantitat = 0;
        //Totes les opcions de aposta (a numero, dotzena, etc)


        int tirada = r.nextInt(36);

        switch (selectOpcio) {
            //Cas de aposta a número
            case 1:
                int num = -1;
                aux = 0;

                do {
                    try {
                        if (aux > 0) {
                            System.out.println("Introdueix un numero VALID (0-36)");
                        }
                        System.out.println("A quin número apostes:");
                        num = n.nextInt();
                    } catch (InputMismatchException e){
                        JOptionPane.showMessageDialog(null, "Error, has d'introduir un numero", "Error", JOptionPane.ERROR_MESSAGE);
                        aux++;
                    }
                } while (num > 36 || num < 0);

                quantitat = aposta();

                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);

                if (num == this.getCaselles()[tirada].getNum()) {
                    player.setMoney(player.getMoney() + quantitat);
                    System.out.println("Has guanyat! ara tens: " + player.getMoney());
                } else {
                    player.setMoney(player.getMoney() - quantitat);
                    System.out.println("Has perdut..., ara tens: " + player.getMoney());
                }
                break;

                //Aposta a dotzenes
            case 2:
                int dotzena = 0;
                aux = 0;
                System.out.println("1. 1-12");
                System.out.println("2. 13-24");
                System.out.println("3. 25-36");
                do {
                    try {
                    if (aux > 0) {
                        System.out.println("Introdueix un numero VALID (1-3)");
                    }
                    System.out.println("Introdueix un número del 1-3, apostes a quina dotzena:");

                    dotzena = n.nextInt();
                    } catch (InputMismatchException e){
                        JOptionPane.showMessageDialog(null, "Error, has d'introduir un numero", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    aux++;
                } while (dotzena > 3 || dotzena <= 0);

                quantitat = aposta();

                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (dotzena == compararDotzena(this.getCaselles()[tirada].getNum())) {
                    System.out.println("Has guanyat " + quantitat * 3 + "€");
                    player.setMoney(player.getMoney() + quantitat * 3);
                    System.out.println("Ara tens: " + player.getMoney() + "€");
                } else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney() - quantitat);
                    System.out.println("Ara tens: " + player.getMoney() + "€");

                }
                break;

            case 3:
                Color color = null;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un color disponible (Vermell/Negre)");
                    }
                    System.out.println("Introdueix a que apostes: Vermell/Negre");
                    String colorInput = n.next().toLowerCase();
                    if (colorInput.equals("vermell")) {
                        color = Color.VERMELL;
                    } else if (colorInput.equals("negre")) {
                        color = Color.NEGRE;
                    }
                    aux++;
                } while (color == null);

                quantitat = aposta();

                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (this.getCaselles()[tirada].getColor() == color){
                    System.out.println("Has guanyat " + quantitat*2 + "€");
                    player.setMoney(player.getMoney()+quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney()-quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }
                break;

            case 4:
                int eleccio;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un Valor disponible (1/2)");
                    }
                    System.out.println("Introdueix a que apostes: 1/2");
                    System.out.println("1. Números del 1-18");
                    System.out.println("2. Números del 19-36");
                    try{
                        eleccio = n.nextInt();
                    } catch (Exception e) {
                        throw new InputMismatchException();
                    }
                    aux++;
                } while (eleccio!=1 && eleccio!=2);

                quantitat = aposta();

                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (this.compararMenorOMajor(this.getCaselles()[tirada].getNum())==eleccio){
                    System.out.println("Has guanyat " + quantitat*2 + "€");
                    player.setMoney(player.getMoney()+quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney()-quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }
                break;

            case 5:
                int eleccio2 = 0;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un Valor disponible (1/2)");
                    }
                    System.out.println("Introdueix a que apostes: 1/2");
                    System.out.println("1. Números imparells");
                    System.out.println("2. Números parells");
                        try {
                            eleccio2 = n.nextInt();
                        }catch (InputMismatchException e){
                            throw new InputMismatchException();
                        }

                    aux++;
                } while (eleccio2!=1 && eleccio2!=2);

                quantitat = aposta();
                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (jugaParell(this.getCaselles()[tirada].getNum())==eleccio2){
                    System.out.println("Has guanyat " + quantitat*2 + "€");
                    player.setMoney(player.getMoney()+quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney()-quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }
                break;
            // Seguir el tipo de aposta (parell o imparell)
            default:
                System.out.println("Error, valor no valid");
                break;
        }
    }

    public int compararMenorOMajor(int numCasella){
        int menorOMajor=0;
        for (int i = 1; i <= 18; i++) {
            if (numCasella == i) {
                menorOMajor = 1;
                return menorOMajor;
            }
        }
        for (int i = 19; i <= 36; i++) {
            if (numCasella == i) {
                menorOMajor = 2;
                return menorOMajor;
            }
        }
        return menorOMajor;
    }

    public int compararDotzena(int numCasella) {
        int dotzena = 0;
        for (int i = 1; i <= 12; i++) {
            if (numCasella == i) {
                dotzena = 1;
                return dotzena;
            }
        }
        for (int i = 13; i <= 24; i++) {
            if (numCasella == i) {
                dotzena = 2;
                return dotzena;
            }
        }
        for (int i = 25; i <= 36; i++) {
            if (numCasella == i) {
                dotzena = 3;
                return dotzena;
            }
        }
        return dotzena;
    }

    private double aposta(){
        int aux = 0;
        double quantitat = 0;
        Scanner n = new Scanner(System.in);
        do {
            System.out.println("Tens " + player.getMoney() + "€");
            if (aux > 0) {
                System.out.println("Introdueix una quantitat que tinguis, eres un pobre");
            }
            System.out.println("Cuanta pasta vols apostar?");
            try{
                quantitat = n.nextDouble();
            }catch (InputMismatchException e){
                throw new InputMismatchException();
            }
            aux++;
        } while (quantitat >= player.getMoney() || quantitat <= 0);
        return quantitat;
    }

    @Override
    public String toString() {
        return "Tauler {" +
                "caselles=" + Arrays.toString(caselles) +
                '}';
    }
}
