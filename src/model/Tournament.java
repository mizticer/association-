package model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private String name;
    private String month;
    private List<Player> players;
    //TODO: ZBIÓR REZULTATÓW

    public Tournament(String name, String month) {
        this.name = name;
        this.month = month;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if(players.contains(player)){
            throw new IllegalArgumentException("Player is already in the tournament");
        }
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }
}
