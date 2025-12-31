package precisiondraw;

import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int guessCards(Scanner sc) {
        System.out.print(name + ", enter number of cards: ");
        return sc.nextInt();
    }

    public String getName() {
        return name;
    }
}
