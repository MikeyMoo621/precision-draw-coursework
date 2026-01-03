package precisiondraw;

public class Round {
    private int target;

    public Round(int target) {
        this.target = target;
    }

    public int calculateScore(Card[] hand, int count) {
        int total = CardValueCalculator.calculateTotal(hand, count);

        if (total == target) return -5;
        if (total < target) return target - total;
        return 2 * (total - target);
    }

    public boolean isUnderOrEqual(Card[] hand, int count) {
        int total = CardValueCalculator.calculateTotal(hand, count);
        return total <= target;
    }

}

