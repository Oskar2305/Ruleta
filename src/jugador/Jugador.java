package jugador;

public class Jugador {
    private double money;
    public final String NOMBRE;

    public Jugador(String nom) {
        //TODO: crea forma d'inicialitzar el nom a main
        NOMBRE = nom;
        this.money = 1000;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
