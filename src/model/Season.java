package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Season {
    private List<Tournament> tournaments;
    private List<Player> playerList;

    public Season() {
        this.tournaments = new ArrayList<>();
        this.playerList = new ArrayList<>();
    }

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public Player getBestPlayerInTournaments(String tournamentName) {
        return playerList.stream()
                .filter(player -> player.tookPart(tournamentName))
                .max(Comparator.comparingInt(player -> player.getPoints(tournamentName)))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }

    public Player getPlayerWithMostFirstPlaces() {
        return playerList.stream()
                .max(Comparator.comparingInt(player -> player.getNumberOfPlaces(1)))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }

    public Player getPlayerWithMostPointsWithoutWinning() {
        return playerList.stream()
                .max(Comparator.comparingInt(Player::getHighestRankingWithoutWinning))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }
}
