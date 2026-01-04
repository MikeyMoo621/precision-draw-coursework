package precisiondraw;

import java.util.Random;

public class SimulatedPlayerPool {

    private SimulatedPlayer[] players;
    private Random rand = new Random();

    public SimulatedPlayerPool() {
        players = new SimulatedPlayer[] {
                new SimulatedPlayer("Sim1"),
                new SimulatedPlayer("Sim2"),
                new SimulatedPlayer("Sim3"),
                new SimulatedPlayer("Sim4"),
                new SimulatedPlayer("Sim5"),
                new SimulatedPlayer("Sim6"),
                new SimulatedPlayer("Sim7"),
                new SimulatedPlayer("Sim8")
        };
    }

    public SimulatedPlayer getRandomPlayer() {
        return players[rand.nextInt(players.length)];
    }

    public SimulatedPlayer[] getTwoDistinctPlayers() {
        SimulatedPlayer p1 = getRandomPlayer();
        SimulatedPlayer p2;

        do {
            p2 = getRandomPlayer();
        } while (p1 == p2);

        return new SimulatedPlayer[] { p1, p2 };
    }
}
