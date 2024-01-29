package model;

import java.util.Date;

public class Lesson {
    private Student student;
    private Teacher teacher;
    private Date date;

    public Lesson(Date date) {
        this.date = date;
    }

    public void setStudent(Student student) {
        this.student = student;
        student.addLesson(this);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.addLesson(this);
    }

    public Date getDate() {
        return date;
    }
}
