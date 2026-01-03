package precisiondraw;

import java.util.Scanner;

public class GameMenu {
    private Scanner sc = new Scanner(System.in);
    private Leaderboard leaderboard = new Leaderboard();


    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("=== Precision Draw ===");
            System.out.println("1. Draw cards");
            System.out.println("2. Draw cards with total");
            System.out.println("3. Guess cards");
            System.out.println("4. Play scored round");
            System.out.println("5. Two-player match");
            System.out.println("6. Play vs Computer");
            System.out.println("7. View Leaderboard");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            if (choice == 1) drawOnly();
            else if (choice == 2) drawWithTotal();
            else if (choice == 3) playGuessingGame();
            else if (choice == 4) playScoredRound();
            else if (choice == 5) playMatch();
            else if (choice == 6) playVsComputer();
            else if (choice == 7) viewLeaderboard();
            else running = false;
        }
    }

    private void drawOnly() {
        Deck deck = new Deck();
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.draw());
        }
    }

    private void drawWithTotal() {
        Deck deck = new Deck();
        Card[] hand = new Card[3];
        for (int i = 0; i < 3; i++) {
            hand[i] = deck.draw();
            System.out.println(hand[i]);
        }
        System.out.println("Total: " +
                CardValueCalculator.calculateTotal(hand, 3));
    }

    private void playGuessingGame() {
        Player p = new Player("Player");
        Deck deck = new Deck();

        int guess = p.guessCards(sc);
        Card[] hand = new Card[guess];

        for (int i = 0; i < guess; i++) {
            hand[i] = deck.draw();
            System.out.println(hand[i]);
        }

        System.out.println("Total: " +
                CardValueCalculator.calculateTotal(hand, guess));
    }

    private void playScoredRound() {
        Round round = new Round(40);
        Player p = new Player("Player");
        Deck deck = new Deck();

        int guess = p.guessCards(sc);
        Card[] hand = new Card[guess];

        for (int i = 0; i < guess; i++) {
            hand[i] = deck.draw();
            System.out.println(hand[i]);
        }

        int score = round.calculateScore(hand, guess);
        System.out.println("Score change: " + score);
    }

    private void playMatch() {
        System.out.print("Player 1 name: ");
        Player p1 = new Player(sc.next());

        System.out.print("Player 2 name: ");
        Player p2 = new Player(sc.next());

        Match match = new Match(p1, p2, leaderboard);
        match.play(sc);
    }

    private void playVsComputer() {
        System.out.print("Enter your name: ");
        Player human = new Player(sc.next());

        Player computer = new SimulatedPlayer("Computer");

        Match match = new Match(human, computer, leaderboard);
        match.play(sc);
    }

    private void viewLeaderboard() {
        leaderboard.display();
    }




}
