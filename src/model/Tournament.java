package model;

import java.util.*;

public class Tournament {
    private String name;
    private String month;
    private List<Player> playerList;

    public Tournament(String name, String month) {
        this.name = name;
        this.month = month;
        playerList = new ArrayList<>();
    }

    public void addPlayer(Player player, int place) {
        playerList.add(player);
        player.addResultForTournaments(this, place);
    }

    public Player findBestPlayer() throws NoSuchElementException {
        return playerList.stream()
                .max(Comparator.comparingInt(player -> player.getPointsForTournament(this)))
                .orElseThrow(() -> new NoSuchElementException("No players in the tournament."));
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
