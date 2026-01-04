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

    public PlayerStats getStats(String name) {
        return players.get(name);
    }

    public void compare(String p1, String p2) {
        PlayerStats s1 = players.get(p1);
        PlayerStats s2 = players.get(p2);

        if (s1 == null || s2 == null) {
            System.out.println("One or both players not found.");
            return;
        }

        System.out.println(p1 + " vs " + p2);
        System.out.println("Wins: " + s1.wins + " | " + s2.wins);
        System.out.println("Matches: " + s1.matchesPlayed + " | " + s2.matchesPlayed);
    }


}
