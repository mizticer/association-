package model;

import java.util.Date;

public class EquipmentUsage {
    private Trainer trainer;
    private Equipment equipment;
    private Date rentDate;

    public EquipmentUsage(Trainer trainer, Equipment equipment, Date rentDate) {
        this.trainer = trainer;
        this.equipment = equipment;
        this.rentDate = rentDate;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
