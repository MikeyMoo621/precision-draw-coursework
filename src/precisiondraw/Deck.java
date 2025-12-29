package precisiondraw;

import java.util.Random;

public class Deck {
    private Card[] cards;
    private int nextIndex;

    public Deck() {
        cards = new Card[52];
        String[] ranks = {
                "2","3","4","5","6","7","8","9","10",
                "J","Q","K","A"
        };
        int idx = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (String r : ranks) {
                cards[idx++] = new Card(r);
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        nextIndex = 0;
    }

    public Card draw() {
        return cards[nextIndex++];
    }
}
