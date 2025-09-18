package tauler;

public class Casella {
    private int num;
    private String color;

    public Casella(int num, String color) {
        this.num = num;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Casella{" +
                "num=" + num +
                ", color='" + color + '\'' +
                '}';
    }
}
