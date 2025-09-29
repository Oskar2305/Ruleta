package main;

import joc.Tauler;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Tauler n = new Tauler();
        try {
            n.bet();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha hagut un error");
        }
    }
}