package precisiondraw;

import java.util.Scanner;

public class SimulationRunner {

    private SimulatedPlayerPool pool;
    private Leaderboard leaderboard;

    public SimulationRunner(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
        this.pool = new SimulatedPlayerPool();
    }

    public void runSimulations(int count) {
        Scanner dummyScanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            SimulatedPlayer[] players = pool.getTwoDistinctPlayers();
            Match match = new Match(players[0], players[1], leaderboard);
            match.play(dummyScanner);
        }

        System.out.println(count + " simulated matches completed.");
    }
}
