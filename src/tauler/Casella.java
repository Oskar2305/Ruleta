package tauler;

public class Casella {
    private int num;
    private String color;

    public Casella(int num, String color) {
        this.num = num;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return num + " que és color " + color;
    }

}
