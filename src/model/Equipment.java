package model;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private String name;
    private Condition condition;
    private int repairCount;
    private List<EquipmentUsage> equipmentUsages;

    public Equipment(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
        this.repairCount = 0;
        equipmentUsages = new ArrayList<>();
    }

    public void repair() {
        if (condition == Condition.TRAGIC) {
            condition = Condition.USED;
            repairCount++;
        }
    }

    public void addUsage(EquipmentUsage usage){
        equipmentUsages.add(usage);
    }

    public void destroy() {
        if (condition == Condition.NEW || condition == Condition.USED) {
            condition = Condition.TRAGIC;
        }
    }

    public int getRepairCount() {
        return repairCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", condition=" + condition +
                '}';
    }
}
