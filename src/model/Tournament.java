package model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private String name;
    private String month;
    private List<Player> players;

    public Tournament(String name, String month) {
        this.name = name;
        this.month = month;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }
}
