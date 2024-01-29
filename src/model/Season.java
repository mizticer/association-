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
        return tournaments.stream()
                .filter(tournament -> tournament.getName().equals(tournamentName))
                .flatMap(tournament -> tournament.getResultSet().stream())
                .max(Comparator.comparingInt(Result::getPoints))
                .map(result -> result.getPlayer())
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }

    public Player getPlayerWithMostFirstPlaces() {
        return playerList.stream()
                .max(Comparator.comparingInt(Player::getNumberOfWins))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }

    public Player getPlayerWithMostPointsWithoutWinning() {
        return playerList.stream()
                .max(Comparator.comparingInt(Player::getHighestRankingWithoutWinning))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }
}
