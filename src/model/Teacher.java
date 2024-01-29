package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher extends Person {
    private Date hireDate;
    private List<Language> languages;
    private List<Student> students;
    private List<Lesson> lessons;

    public Teacher(String firstName, String lastName, Date hireDate, List<Language> languages) {
        super(firstName, lastName);
        this.hireDate = hireDate;
        this.languages = languages;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public List<Student> getStudents() {
        return students;
    }
}
