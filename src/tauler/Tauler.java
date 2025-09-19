package tauler;

import jugador.Jugador;

import java.util.Arrays;
import java.util.Scanner;

public class Tauler {
    Jugador player = new Jugador();
    private Casella[] caselles;

    public Tauler() {
        int i = 1;
        this.caselles = new Casella[37];
        this.caselles[0] = new Casella(0, "Green");
        do {

            this.caselles[i] = new Casella(i, "Red");
            i++;
            if (i <= 10) {
                this.caselles[i] = new Casella(i, "Black");
                i++;
            }
        } while (i <= 10);
        do {
            this.caselles[i] = new Casella(i, "Black");
            i++;
            if (i <= 18) {
                this.caselles[i] = new Casella(i, "Red");
                i++;
            }
        } while (i <= 18);
        do {
            this.caselles[i] = new Casella(i, "Red");
            i++;
            if (i <= 28) {
                this.caselles[i] = new Casella(i, "Black");
                i++;
            }
        } while (i <= 28);
        do {
            this.caselles[i] = new Casella(i, "Black");
            i++;
            if (i <= 36) {
                this.caselles[i] = new Casella(i, "Red");
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
    public void bet() {
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
            selectOpcio = n.nextInt();
            aux++;
        } while (selectOpcio >= 5 || selectOpcio <= 0);

        /*Quantitat ha apostar*/

        double quantitat;
        //Totes les opcions de aposta (a numero, dotzena, etc)

        int tirada = tirada();

        switch (selectOpcio) {
            //Cas de aposta a número
            case 1:
                int num;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un numero VALID (0-36)");
                    }
                    System.out.println("A quin número apostes:");
                    num = n.nextInt();
                    aux++;
                } while (num > 36 || num < 0);
                aux = 0;
                do {
                    System.out.println("Tens " + player.getMoney() + "€");
                    if (aux > 0) {
                        System.out.println("Introdueix una quantitat que tinguis, eres un pobre");
                    }
                    System.out.println("Cuanta pasta vols apostar?");
                    quantitat = n.nextDouble();
                    aux++;
                } while ((double) quantitat >= player.getMoney() || quantitat <= 0);

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
                    dotzena = n.nextInt();
                    aux++;
                } while (dotzena > 3 || dotzena <= 0);

                aux = 0;
                do {
                    System.out.println("Tens " + player.getMoney() + "€");
                    if (aux > 0) {
                        System.out.println("Introdueix una quantitat que tinguis, eres un pobre");
                    }
                    System.out.println("Cuanta pasta vols apostar?");
                    quantitat = n.nextDouble();
                    aux++;
                } while ((double) quantitat >= player.getMoney() || quantitat <= 0);
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
                int color;
                aux = 0;
                do {
                    if (aux > 0) {
                        System.out.println("Introdueix un numero VALID (1/2)");
                    }
                    System.out.println("Introdueix un número del 1 o 2, 1 = Vermell, 2 = Negre");
                    color = n.nextInt();
                    aux++;
                } while (color != 1 && color != 2);

                aux = 0;
                do {
                    System.out.println("Tens " + player.getMoney() + "€");
                    if (aux > 0) {
                        System.out.println("Introdueix una quantitat que tinguis, eres un pobre");
                    }
                    System.out.println("Cuanta pasta vols apostar?");
                    quantitat = n.nextDouble();
                    aux++;
                } while ((double) quantitat >= player.getMoney() || quantitat <= 0);
                System.out.println("La bola ha caigut a " + this.getCaselles()[tirada]);
                break;

            // Seguir el tipo de apuesta (Color, menor o major y parell o imparell)
        }


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
