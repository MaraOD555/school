package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>(); // мапа для хранения данных
    private long count = 0; // счетчик, назначаем для Id

    public Student createStudent(Student student) {
        student.setId(count++); //счетчик, изначально 0, автоматически добавляет 1 при каждом вызове метода
        students.put(student.getId(), student); // кладем слудента в мапу по ключу(ID).
        return student;
    }
    public Student findStudent(long Id) { // находим по ключу
        return students.get(Id);
    }
    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) { // если есть такой Id, то вносим изменения и кладем в мапу
            students.put(student.getId(), student);
            return student;
        }
        return null; // если нет то возвращается ноль
    }
    public Student deleteStudents(long Id){
        return students.remove(Id); // удаляем по Id
    }

    public Collection<Student> findByAge(int age) { // ищем студентов по возрасту
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students.values()) { // перебираем и добавляем в коллекцию, если возраст совпадает с искомым
            if (student.getAge() == age) {
                list.add(student);
            }
        }
        return list;
    }
}

