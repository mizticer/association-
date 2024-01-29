package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {
    private String firstName;
    private String lastName;
    private Set<Result> resultList;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultList = new HashSet<>();
    }

    public void addResult(Result result) {
        resultList.add(result);
    }

    public int getPoints() {
        return resultList.stream().mapToInt(Result::getPoints).sum();
    }

    public int getNumberOfPlaces(int placeNr) {
        int count = 0;
        for (Result result : resultList) {
            if (result.getPosition() == placeNr) {
                count++;
            }
        }
        return count;
    }

    public int getPoints(String name) {
        return resultList.stream()
                .filter(result -> result.getTournament().getName().equalsIgnoreCase(name))
                .mapToInt(Result::getPoints)
                .sum();
    }

    public boolean tookPart(String name) {
        return resultList.stream()
                .anyMatch(result -> result.getTournament().getName().equalsIgnoreCase(name));
    }

    public int getHighestRankingWithoutWinning() {
        return resultList.stream()
                .filter(result -> result.getPosition() != 1)
                .mapToInt(Result::getPoints)
                .sum();
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName);
    }


}
