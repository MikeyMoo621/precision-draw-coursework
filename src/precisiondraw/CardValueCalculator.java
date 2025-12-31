package precisiondraw;

public class CardValueCalculator {

    public static int calculateTotal(Card[] hand, int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            String r = hand[i].getRank();
            if (r.equals("A")) total += 11;
            else if (r.equals("K") || r.equals("Q") || r.equals("J")) total += 10;
            else total += Integer.parseInt(r);
        }
        return total;
    }
}
