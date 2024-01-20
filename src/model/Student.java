package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private Language language;
    private Teacher teacher;
    private List<Lesson> lessonList;

    public Student(String firstName, String lastName, Language learningLanguage) {
        super(firstName, lastName);
        this.language = learningLanguage;
        lessonList = new ArrayList<>();
    }

    public Language getLanguage() {
        return language;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.getLanguages().contains(language)) {
            this.teacher = teacher;
            teacher.addStudent(this);
        } else {
            throw new IllegalStateException("Teacher does not teach the language of the student.");
        }
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }
}
