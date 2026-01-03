package precisiondraw;

import java.util.Random;
import java.util.Scanner;

public class Match {

    private Player player1;
    private Player player2;

    private Leaderboard leaderboard;

    private int target = 40;
    private int score1 = 0;
    private int score2 = 0;

    public Match(Player p1, Player p2, Leaderboard leaderboard) {
        this.player1 = p1;
        this.player2 = p2;
        this.leaderboard = leaderboard;
    }


    public void play(Scanner sc) {
        Random rand = new Random();
        boolean p1First = rand.nextBoolean();

        System.out.println("\nStarting match between "
                + player1.getName() + " and " + player2.getName());
        System.out.println("Initial target: " + target);

        for (int round = 1; round <= 4; round++) {
            System.out.println("\n--- Round " + round + " ---");

            Deck deck = new Deck();
            Round roundLogic = new Round(target);

            Player first = p1First ? player1 : player2;
            Player second = p1First ? player2 : player1;

            int firstGuess;
            if (first instanceof SimulatedPlayer) {
                firstGuess = ((SimulatedPlayer) first).guessFirst(target);
            } else {
                firstGuess = first.guessCards(sc);
            }

            int secondGuess;
            if (second instanceof SimulatedPlayer) {
                secondGuess = ((SimulatedPlayer) second).guessSecond(firstGuess);
            } else {
                secondGuess = second.guessCards(sc);
            }

            Card[] firstHand = drawHand(deck, firstGuess);
            Card[] secondHand = drawHand(deck, secondGuess);

            int firstScore = roundLogic.calculateScore(firstHand, firstGuess);
            int secondScore = roundLogic.calculateScore(secondHand, secondGuess);

            System.out.println(first.getName() + " score change: " + firstScore);
            System.out.println(second.getName() + " score change: " + secondScore);

            if (first == player1) {
                score1 += firstScore;
                score2 += secondScore;
            } else {
                score1 += secondScore;
                score2 += firstScore;
            }

            boolean firstUnderOrEqual =
                    roundLogic.isUnderOrEqual(firstHand, firstGuess);
            boolean secondUnderOrEqual =
                    roundLogic.isUnderOrEqual(secondHand, secondGuess);

            if (firstUnderOrEqual && secondUnderOrEqual) {
                target += 5;
                System.out.println("Both under target. Target increased to " + target);
            } else if (!firstUnderOrEqual && !secondUnderOrEqual) {
                target -= 5;
                System.out.println("Both over target. Target decreased to " + target);
            }

            if (score1 < score2) {
                leaderboard.recordMatch(player1.getName(), player2.getName());
            } else if (score2 < score1) {
                leaderboard.recordMatch(player2.getName(), player1.getName());
            }


            p1First = !p1First;
        }

        System.out.println("\n--- Match Over ---");
        System.out.println(player1.getName() + " total score: " + score1);
        System.out.println(player2.getName() + " total score: " + score2);

        if (score1 < score2) {
            System.out.println(player1.getName() + " wins!");
        } else if (score2 < score1) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("The match is a draw!");
        }
    }

    private Card[] drawHand(Deck deck, int count) {
        Card[] hand = new Card[count];
        for (int i = 0; i < count; i++) {
            hand[i] = deck.draw();
            System.out.println(hand[i]);
        }
        return hand;
    }
}
