package joc;

import jugador.Jugador;

import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tauler {
    Jugador player = new Jugador();
    private final Casella[] caselles;

    public Tauler() {
        int i = 1;
        this.caselles = new Casella[37];
        this.caselles[0] = new Casella(0, Color.VERD);
        do {

            this.caselles[i] = new Casella(i, Color.VERMELL);
            i++;
            if (i <= 10) {
                this.caselles[i] = new Casella(i, Color.NEGRE);
                i++;
            }
        } while (i <= 10);
        do {
            this.caselles[i] = new Casella(i, Color.NEGRE);
            i++;
            if (i <= 18) {
                this.caselles[i] = new Casella(i, Color.VERMELL);
                i++;
            }
        } while (i <= 18);
        do {
            this.caselles[i] = new Casella(i, Color.VERMELL);
            i++;
            if (i <= 28) {
                this.caselles[i] = new Casella(i, Color.NEGRE);
                i++;
            }
        } while (i <= 28);
        do {
            this.caselles[i] = new Casella(i, Color.NEGRE);
            i++;
            if (i <= 36) {
                this.caselles[i] = new Casella(i, Color.VERMELL);
                i++;
            }
        } while (i <= 36);
    }

    public Casella[] getCaselles() {
        return caselles;
    }


    public int tirada() {
        return (int) (Math.random() * 36 + 0);

    }

    /*Metode utilitzat al main per jugar*/
    public void bet() throws Exception {
        Scanner n = new Scanner(System.in);
        int selectOpcio;
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
                throw new InputMismatchException();
            }

            aux++;
        } while (selectOpcio > 5 || selectOpcio <= 0);

        /*Quantitat ha apostar*/

        double quantitat;
        //Totes les opcions de aposta (a numero, dotzena, etc)

        int tirada = tirada();

        switch (selectOpcio) {
            //Cas de aposta a número
            case 1:
                int num = -1;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un numero VALID (0-36)");
                    }
                    System.out.println("A quin número apostes:");
                    try{
                        num = n.nextInt();
                    }catch (InputMismatchException e){
                        JOptionPane.showMessageDialog(null, "Error: Introdueix un numero valid (0-36)");
                    }

                    aux++;
                } while (num > 36 || num < 0);
                aux = 0;
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

                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);

                if (num == this.getCaselles()[tirada].getNum()) {
                    player.setMoney(player.getMoney() + quantitat);
                    System.out.println("Has guanyat! ara tens: " + player.getMoney());
                } else {
                    player.setMoney(player.getMoney() - quantitat);
                    System.out.println("Has perdut..., ara tens: " + player.getMoney());
                }
                break;

            case 2:
                int dotzena;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un numero VALID (1-3)");
                    }
                    System.out.println("Introdueix un número del 1-3, apostes a quina dotzena:");
                    System.out.println("1. 1-12");
                    System.out.println("2. 13-24");
                    System.out.println("3. 25-36");
                    try{
                        dotzena = n.nextInt();
                    }catch (InputMismatchException e){
                        throw new InputMismatchException();
                    }

                    aux++;
                } while (dotzena > 3 || dotzena <= 0);

                aux = 0;
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
                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (dotzena == compararDotzena(this.getCaselles()[tirada].getNum())) {
                    System.out.println("Has guanyat " + quantitat*3 + "€");
                    player.setMoney(player.getMoney() + quantitat * 2);
                    System.out.println("Ara tens: " + player.getMoney() + "€");
                } else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney() - quantitat);
                    System.out.println("Ara tens: " + player.getMoney() + "€");

                }
                break;

            case 3:
                String color;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un color disponible (Red/Black)");
                    }
                    System.out.println("Introdueix a que apostes: Red/Black");
                    color = n.next().toLowerCase();
                    aux++;
                } while (!color.equals("black") && !color.equals("red"));

                aux = 0;
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
                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (this.getCaselles()[tirada].getColor().toLowerCase().equals(color)){
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

                aux = 0;
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

                aux = 0;
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
                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                if (this.compararParell(this.getCaselles()[tirada].getNum())==eleccio2){
                    System.out.println("Has guanyat " + quantitat*2 + "€");
                    player.setMoney(player.getMoney()+quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }else {
                    System.out.println("Has perdut " + quantitat + "€");
                    player.setMoney(player.getMoney()-quantitat);
                    System.out.println("Ara tens " + player.getMoney() + "€");
                }
                break;
            // Seguir el tipo de apuesta (parell o imparell)
        }


    }


    public int compararParell(int numCasella){
        int parells=0;
        if (numCasella!=0){
            for (int i = 1 ; i <= 36; i++){
                if (numCasella%2==0){
                    parells = 2;
                    return parells;
                }
                if (numCasella%2!=0){
                    parells = 1;
                    return parells;
                }
            }
        }


        return parells;
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

    @Override
    public String toString() {
        return "Tauler{" +
                "caselles=" + Arrays.toString(caselles) +
                '}';
    }
}
