package main;

import joc.Tauler;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Tauler n = new Tauler();
        try {
            n.bet();
        } catch (Exception e) {
            System.out.println("Ha hagut un error");
        }
    }
}