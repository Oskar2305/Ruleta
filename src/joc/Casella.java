package joc;

public class Casella {
    private int num;
    private Color color;

    public Casella(int num, Color color) {
        this.num = num;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return num + " que és color " + color;
    }

}
