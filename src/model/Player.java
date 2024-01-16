package model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String firstName;
    private String lastName;
    private Map<Tournament, Integer> pointsForTournaments;
    private Map<Tournament, Integer> placesInTournaments;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        pointsForTournaments = new HashMap<>();
        placesInTournaments = new HashMap<>();
    }

    public void addResultForTournaments(Tournament tournament, int place) {
        placesInTournaments.put(tournament, place);

        int points = calculatePoints(place);
        pointsForTournaments.put(tournament, points);

    }

    private int calculatePoints(int place) {
        int points = 0;
        if (place == 1) {
            points = 100;
        } else if (place >= 2 && place <= 5) {
            points = 100 - (place - 1) * 20;
        }
        return points;
    }

    public int getPointsForTournament(Tournament tournament) {
        return pointsForTournaments.getOrDefault(tournament, 0);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Map<Tournament, Integer> getPlacesInTournaments() {
        return placesInTournaments;
    }
    public boolean hasFirstPlace(){
        return placesInTournaments.values().contains(1);
    }
}
