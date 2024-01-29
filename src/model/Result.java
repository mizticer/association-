package model;

import java.util.Objects;

public class Result {
    private int position;
    private Player player;
    private Tournament tournament;

    public Result(Player player, Tournament tournament, int position) {
        if (position < 1) {
            throw new IllegalArgumentException("Position must be a positive integer");
        }
        this.position = position;
        this.player = player;
        this.tournament = tournament;
        player.addResult(this);
        tournament.addResult(this);
    }

    public int getPoints() {
        if (position == 1) {
            return 100;
        } else if (position >= 2 && position <= 5) {
            return 100 - (position - 1) * 20;
        } else {
            return 0;
        }
    }

    public int getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, player, tournament);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Result otherResult = (Result) obj;
        return position == otherResult.position &&
                Objects.equals(player, otherResult.player) &&
                Objects.equals(tournament, otherResult.tournament);
    }

    public Tournament getTournament() {
        return tournament;
    }
}
