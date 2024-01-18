package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private Language learningLanguage;
    private Teacher teacher;
    private List<Lesson> lessonList;

    public Student(String firstName, String lastName, Language learningLanguage) {
        super(firstName, lastName);
        this.learningLanguage = learningLanguage;
        lessonList = new ArrayList<>();
    }

    public Language getLearningLanguage() {
        return learningLanguage;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher.getLanguages().contains(learningLanguage)) {
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
