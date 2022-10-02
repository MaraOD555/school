package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {
    private final FacultyService out = new FacultyService();

    @Test
    void createFaculty() {
        Faculty expected = new Faculty(0, "111", "1");
        Faculty expected1 = new Faculty(1, "222", "2");
        Faculty actual = out.createFaculty(expected);
        Faculty actual1 = out.createFaculty(expected1);
        assertEquals(expected, actual);
        System.out.println(actual);
        assertEquals(expected1, actual1);
        System.out.println(actual1);
    }
    @Test
    void findFaculty() {
        Faculty expected = out.createFaculty(new Faculty(0, "111", "1"));
        Faculty expected1 = out.createFaculty(new Faculty(1, "222", "2"));
        Faculty expected2 = out.createFaculty(new Faculty(2, "333", "3"));
        Faculty result = out.findFaculty(expected.getId());
        Faculty result1 = out.findFaculty(expected1.getId());
        Faculty result2 = out.findFaculty(expected2.getId());
        assertThat(result).isEqualTo(expected);
        System.out.println(result1);
    }

    @Test
    void editFaculty() {
        Faculty expected = out.createFaculty(new Faculty(0, "111", "1"));
        Faculty expected1 = out.createFaculty(new Faculty(1, "222", "2"));
        Faculty expected2 = out.createFaculty(new Faculty(2, "333", "3"));
        Faculty result = out.editFaculty(expected);
        assertThat(result).isEqualTo(expected);
        System.out.println(result);
        Faculty result1 = out.editFaculty(expected1);
        assertThat(result1).isEqualTo(expected1);
        System.out.println(result1);
        out.deleteFaculty(2);
        Faculty result2 = out.editFaculty(expected2);
        assertThat(result2).isNull();
    }

    @Test
    void deleteFaculty() {
        Faculty expected = out.createFaculty(new Faculty(0, "111", "1"));
        Faculty expected1 = out.createFaculty(new Faculty(1, "222", "2"));
        Faculty expected2 = out.createFaculty(new Faculty(2, "333", "3"));
        Faculty result = out.deleteFaculty(expected.getId());
        Faculty result1 = out.deleteFaculty(expected1.getId());
        assertThat(result).isEqualTo(expected);
        System.out.println(result1);
        System.out.println(out.findFaculty(expected.getId()));
        Faculty result2 = out.deleteFaculty(expected2.getId());
        System.out.println(out.createFaculty(result2));
    }

    @Test
    void findFacultyByColor() {
        out.createFaculty(new Faculty(0, "111", "1"));
        out.createFaculty(new Faculty(1, "222", "2"));
        out.createFaculty(new Faculty(2, "333", "2"));
        out.createFaculty(new Faculty(3, "444", "3"));

        List<Faculty> expected = new ArrayList<>(List.of(
                new Faculty(1, "222", "2"),
                new Faculty(2, "333", "2")
        ));
        assertThat(out.findFacultyByColor("2")).containsExactlyElementsOf(expected);
        System.out.println(out.findFacultyByColor("2"));
    }
}