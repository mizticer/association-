import model.Lesson;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class School {
    private List<Student> studentList;
    private List<Teacher> teacherList;

    public School() {
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void addLesson(Lesson lesson, Student student, Teacher teacher) {
        if (lesson.getDate().before(new Date())) {
            throw new IllegalArgumentException("Cannot create lesson in the past.");
        }
        lesson.setStudent(student);
        lesson.setTeacher(teacher);
    }

    public Student studentWithTheMostLessons() {
        return studentList.stream()
                .max(Comparator.comparingInt(o -> o.getLessonList().size()))
                .orElseThrow();
    }

    public Teacher teacherWithTheMostStudents() {
        return teacherList.stream()
                .max(Comparator.comparingInt(o -> o.getStudents().size()))
                .orElseThrow();
    }
}
