package uk.ac.aston.oop.dpatterns.singleton;

import java.util.Random;

public class DiceRoller {

    private static DiceRoller instance = null;
    private static Long seed = null;
    private final Random random;

    private DiceRoller() {
        if (seed != null) {
            random = new Random(seed);
        } else {
            random = new Random();
        }
    }

    public static DiceRoller getInstance() {
        if (instance == null) {
            instance = new DiceRoller();
        }
        return instance;
    }

    public static void setSeed(long newSeed) {
        if (instance == null) {
            seed = newSeed;
        } else {
            System.err.println("Seed cannot be set after DiceRoller instance is created.");
        }
    }

    public int roll(int faces) {
        return random.nextInt(faces) + 1;
    }
}
