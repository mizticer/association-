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

    public void addLesson(Lesson lesson, Student student) {
        if (lesson.getDate().before(new Date())) {
            throw new IllegalArgumentException("Cannot create lesson in the past.");
        }
        lesson.setStudent(student);
        student.addLesson(lesson);
    }

    public Student studentWithTheMostLessons() {
        return studentList.stream()
                .max(Comparator.comparingInt(o -> o.getLessonList().size()))
                .orElse(null);
    }

    public Teacher teacherWithTheMostStudents() {
        return teacherList.stream()
                .max(Comparator.comparingInt(o -> o.getStudents().size()))
                .orElse(null);
    }
}
