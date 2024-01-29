package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Tournament {
    private String name;
    private String month;
    private Set<Result> resultSet;

    public Tournament(String name, String month) {
        this.name = name;
        this.month = month;
        resultSet = new HashSet<>();
    }

    public void addResult(Result result) {
        for (Result existingResult : resultSet) {
            if (existingResult.getPlayer().equals(result.getPlayer())) {
                throw new IllegalArgumentException("Player already exists in this tournament.");
            }
        }
        resultSet.add(result);
    }

    public Set<Result> getResultSet() {
        return resultSet;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return Objects.equals(name, that.name) && Objects.equals(month, that.month);
    }
}
