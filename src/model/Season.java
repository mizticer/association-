package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Season {
    private List<Tournament> tournaments;

    public Season() {
        this.tournaments = new ArrayList<>();
    }

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public Player getBestPlayerInTournaments(String tournamentName) {
        return tournaments.stream()
                .filter(tournament -> tournament.getName().equals(tournamentName))
                .flatMap(tournament -> tournament.getPlayers().stream())
                .max(Comparator.comparingInt(Player::getTotalPoints))
                .orElseThrow(() -> new NoSuchElementException("No players in the specified tournament"));
    }

    public Player getPlayerWithMostFirstPlaces() {
        return tournaments.stream()
                .flatMap(tournament -> tournament.getPlayers().stream())
                .max(Comparator.comparingInt(player -> {
                    long firstPlaces = player.getResults().values().stream()
                            .filter(result -> result.getPosition() == 1)
                            .count();
                    return (int) firstPlaces;
                }))
                .orElseThrow(() -> new NoSuchElementException("No player with most first places found"));
    }

    public Player getPlayerWithMostPointsWithoutWinning() {
        return tournaments.stream()
                .flatMap(tournament -> tournament.getPlayers().stream())
                .filter(player -> !player.hasWonAnyTournament())
                .max(Comparator.comparingInt(Player::getTotalPoints))
                .orElseThrow(() -> new NoSuchElementException("No player with most points without winning found"));

    }
}
