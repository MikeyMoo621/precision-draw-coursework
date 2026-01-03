package precisiondraw;

public class Leaderboard {

    private SimpleMap players = new SimpleMap();

    public void recordMatch(String winner, String loser) {
        PlayerStats w = players.putIfAbsent(winner);
        PlayerStats l = players.putIfAbsent(loser);

        w.matchesPlayed++;
        w.wins++;

        l.matchesPlayed++;
    }

    public void display() {
        System.out.println("\n=== Leaderboard ===");
        for (int i = 0; i < players.size(); i++) {
            PlayerStats s = players.getValue(i);
            System.out.println(players.getKey(i)
                    + " | Wins: " + s.wins
                    + " | Matches: " + s.matchesPlayed);
        }
    }
}
