package model;

import java.util.Date;

public class Lesson {
    private Student student;
    private Date date;

    public Lesson(Date date) {
        this.date = date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }
}
