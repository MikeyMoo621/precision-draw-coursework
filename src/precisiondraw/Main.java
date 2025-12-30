package precisiondraw;

public class Main {
    public static void main(String[] args) {
        new GameMenu().start();
        Deck deck = new Deck();
        System.out.println("Testing deck draw:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.draw());
        }
    }
}
