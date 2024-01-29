import model.Language;
import model.Lesson;
import model.Student;
import model.Teacher;

import java.util.Date;
import java.util.List;

public class Main {
    /*
Napisz program do zarządzania kursami.
Nauczyciel ma imię, nazwisko, datę zatrudnienia i może uczyć wielu języków
Student ma imię, nazwisko, język którego się uczy.
Student może mieć jednego nauczyciela
Nauczyciel może mieć wielu studentów

zbuduj program tak by dało się dodawać lekcje (termin)

-przypisywanie kursantowi Nauczyciela musi weryfikować język
-lekcja nie może być dodawana w przeszłości.
-znajdz kursanta, który ma najwięcej lekcji
-znajdz nauczyciela, który ma najwięcej kursantów
*/
    public static void main(String[] args) {
            Language english = new Language("English");
            Language spanish = new Language("Spanish");
            Language french = new Language("French");

            Teacher teacher1 = new Teacher("John", "Doe", new Date(), List.of(english, spanish));
            Teacher teacher2 = new Teacher("Jane", "Smith", new Date(), List.of(french));

            Student student1 = new Student("Alice", "Johnson", english);
            Student student2 = new Student("Bob", "Williams", spanish);
            Student student3 = new Student("Charlie", "Davis", french);

            School school = new School();
            school.addTeacher(teacher1);
            school.addTeacher(teacher2);
            school.addStudent(student1);
            school.addStudent(student2);
            school.addStudent(student3);

            student1.setTeacher(teacher1);
            student2.setTeacher(teacher1);
            student3.setTeacher(teacher2);

            Lesson lesson1 = new Lesson(new Date());
            Lesson lesson2 = new Lesson(new Date(System.currentTimeMillis() + 1000000000));
            Lesson lesson3 = new Lesson(new Date(System.currentTimeMillis() + 2000000000));
            Lesson lesson4 = new Lesson(new Date(System.currentTimeMillis() + 1200000000));

            school.addLesson(lesson1, student1);
            school.addLesson(lesson2, student2);
            school.addLesson(lesson3, student3);
            school.addLesson(lesson4, student3);

            Student studentWithMostLessons = school.studentWithTheMostLessons();
            Teacher teacherWithMostStudents = school.teacherWithTheMostStudents();

            System.out.println("Student with the most lessons: " + studentWithMostLessons.getFirstName() + " " + studentWithMostLessons.getLastName());
            System.out.println("Teacher with the most students: " + teacherWithMostStudents.getFirstName() + " " + teacherWithMostStudents.getLastName());
    }
}