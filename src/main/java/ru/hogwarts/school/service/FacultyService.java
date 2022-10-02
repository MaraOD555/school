package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long count = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }
    public Faculty findFaculty(long Id) {
        return faculties.get(Id);
    }
    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long Id){
        return faculties.remove(Id);
    }
    public Collection<Faculty> findFacultyByColor(String color) {
        ArrayList<Faculty> listOfFaculties = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                listOfFaculties.add(faculty);
            }
        }
        return listOfFaculties;
    }
}
