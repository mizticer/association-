package model;

public class Equipment {
    private String name;
    private Condition condition;
    private int repairCount;

    public Equipment(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
        this.repairCount = 0;
    }

    public void repair() {
        if (condition == Condition.TRAGIC) {
            condition = Condition.NEW;
            repairCount++;
        }
    }
}
