package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String firstName;
    private String lastName;
    private List<Result> resultList;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultList = new ArrayList<>();
    }

    public void addResult(Result result) {
        resultList.add(result);
    }

    public int getTotalPoints() {
        return resultList.stream().mapToInt(Result::getPoints).sum();
    }

    public int getNumberOfWins() {
        int count = 0;
        for (Result result : resultList) {
            if (result.getPosition() == 1) {
                count++;
            }
        }
        return count;
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
