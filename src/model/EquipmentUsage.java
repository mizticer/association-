package model;

import java.util.Date;

public class EquipmentUsage {
    private Trainer trainer;
    private Equipment equipment;
    private Date startDate;
    private Date endDate;
    public EquipmentUsage(Trainer trainer, Equipment equipment, Date startDate) {
        this.trainer = trainer;
        this.equipment = equipment;
        this.startDate = startDate;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
