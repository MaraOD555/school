package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private final StudentService out = new StudentService();

    @Test
    void createStudent() {
        Student expected = new Student(0, "Irina", 22);
        Student expected1 = new Student(1, "Ivan", 22);
        Student actual = out.createStudent(expected);
        Student actual1 = out.createStudent(expected1);
        assertEquals(expected, actual);
        System.out.println(actual);
        assertEquals(expected1, actual1);
        System.out.println(actual1);
    }

    @Test
    void findStudent() {
       Student expected = out.createStudent(new Student(0, "Ivan", 22));
       Student expected1 = out.createStudent(new Student(1, "Irina", 22));
       Student expected2 = out.createStudent(new Student(2, "Eva", 20));
       Student result = out.findStudent(expected.getId());
       Student result1 = out.findStudent(expected1.getId());
       Student result2 = out.findStudent(expected2.getId());
       assertThat(result).isEqualTo(expected);
       System.out.println(result1);
    }

    @Test
    void editStudent() {
        Student expected = out.createStudent(new Student(0, "Irina", 22));
        Student expected1 = out.createStudent(new Student(1, "Eva", 20));
        Student expected2 = out.createStudent(new Student(2, "Oleg", 20));
        Student result = out.editStudent(expected);
        assertThat(result).isEqualTo(expected);
        System.out.println(expected);
        Student result1 = out.editStudent(expected1);
        assertThat(result1).isEqualTo(expected1);
        System.out.println(expected1);
        out.deleteStudents(2);
        Student result2 = out.editStudent(expected2);
        assertThat(result2).isNull();
        System.out.println(result2);
    }

    @Test
    void deleteStudents() {
        Student expected = out.createStudent(new Student(0, "Ivan", 22));
        Student expected1 = out.createStudent(new Student(1, "Irina", 22));
        Student expected2 = out.createStudent(new Student(2, "Eva", 20));
        Student result = out.deleteStudents(expected.getId());
        Student result1 = out.deleteStudents(expected1.getId());
        Student result2 = out.deleteStudents(expected2.getId());
        assertThat(result).isEqualTo(expected);
        System.out.println(result1);
    }
    @Test
    void findByAge() {
        out.createStudent(new Student(0, "Irina", 20));
        out.createStudent(new Student(1, "Egor", 22));
        out.createStudent(new Student(2,  "Eva", 20));
        out.createStudent(new Student(3, "Oleg", 20));

        List<Student> expected = new ArrayList<>(List.of(

                new Student(0, "Irina", 20),
                new Student(2,  "Eva", 20),
                new Student(3, "Oleg", 20)
        ));
        assertThat(out.findByAge(20)).containsAnyElementsOf(expected);
        System.out.println(out.findByAge(20));
        List<Student> expected1 = new ArrayList<>(List.of(

                new Student(1, "Egor", 22)
        ));
       assertThat(out.findByAge(22)).containsAnyElementsOf(expected1);
        System.out.println(out.findByAge(22));
    }
}