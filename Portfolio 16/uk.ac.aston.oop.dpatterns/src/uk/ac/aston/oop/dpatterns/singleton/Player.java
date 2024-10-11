package uk.ac.aston.oop.dpatterns.singleton;

import java.util.Random;

public class Player {

    private static Player instance;
    private final int dieFaces;

    public Player(int dieFaces) {
        this.dieFaces = dieFaces;
    }

    public static synchronized Player getInstance(int dieFaces) {
        if (instance == null) {
            instance = new Player(dieFaces);
        }
        return instance;
    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(dieFaces) + 1;
    }

    public int getDieFaces() {
        return dieFaces;
    }
}
