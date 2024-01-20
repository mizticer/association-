package model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String firstName;
    private String lastName;
    private Map<Tournament, Result> results;
    //TODO: DODAJ LISTE TURNIEJÓW

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.results = new HashMap<>();
    }

    public Map<Tournament, Result> getResults() {
        return results;
    }

    public void addResult(Tournament tournament, int position) {
        if (position < 1) {
            throw new IllegalArgumentException("Position must be a positive integer");
        }
        if (results.values().stream().anyMatch(result -> result.getPosition() == position)) {
            throw new IllegalArgumentException("Player cannot have the same position in the tournament");
        }
        Result result = new Result(position);
        results.put(tournament, result);
        tournament.addPlayer(this);
    }

    public int getTotalPoints() {
        return results.values().stream().mapToInt(Result::getPoints).sum();
    }


    public boolean hasWonAnyTournament() {
        return results.values().stream().anyMatch(result -> result.getPosition() == 1);
    }

    public int getHighestRankingWithoutWinning() {
        return results.values().stream()
                .filter(result -> result.getPosition() != 1)
                .mapToInt(Result::getPoints)
                .max()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
