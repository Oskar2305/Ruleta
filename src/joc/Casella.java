package joc;

public class Casella {
    private final int num;
    private final Color color;

    public Casella(int num, Color color) {
        this.num = num;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public Color getColor() {
        return color;
    }
    @Override
    public String toString() {
        return num + " que és color " + color;
    }

}
