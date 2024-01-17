package model;

public class Result {
    private int position;
    private int points;

    public Result(int position) {
        if (position < 1) {
            throw new IllegalArgumentException("Position must be a positive integer");
        }
        this.position = position;
        calculatePoints();
    }

    private void calculatePoints() {
        if (position == 1) {
            points = 100;
        } else if (position >= 2 && position <= 5) {
            points = 100 - (position - 1) * 20;
        } else {
            points = 0;
        }
    }


    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }
}
