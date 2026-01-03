package precisiondraw;

import java.util.Random;

public class SimulatedPlayer extends Player {

    private Random rand = new Random();

    public SimulatedPlayer(String name) {
        super(name);
    }


    public int guessFirst(int target) {
        int base = target / 10;
        int variation = rand.nextInt(3);
        int guess = base + variation;

        if (guess < 2) guess = 2;
        if (guess > 8) guess = 8;

        System.out.println(getName() + " guesses " + guess + " cards.");
        return guess;
    }


    public int guessSecond(int firstGuess) {
        int guess = firstGuess + 2 + rand.nextInt(2);
        System.out.println(getName() + " guesses " + guess + " cards.");
        return guess;
    }
}
