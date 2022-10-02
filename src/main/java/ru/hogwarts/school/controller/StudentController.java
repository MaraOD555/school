package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("{Id}") // чтобы в браузере получать информацию по заданным Id
    public ResponseEntity<Student> findStudentInfo (@PathVariable long Id){ // аннотация для ввода Id
        Student student = studentService.findStudent(Id); // переменная
        if(student == null){
            return ResponseEntity.notFound().build(); // если нет такого Id, то исключение, в данном случает ответ объекта (Response Entity - nor found)
        }
        return ResponseEntity.ok(student);// если найден. что все ок. возвращаем студента
    }
    @PostMapping // аннотация для ввода информации, отправки
    public Student createStudent(@RequestBody Student student){// ввод параметров в теле запроса в аннотацией @RequestBody
        return studentService.createStudent(student);
    }
    @PutMapping // аннотация для edit
    public ResponseEntity<Student> editStudentInfo (@RequestBody Student student){ // аннотация для ввода данных в теле запроса(новые данные)
        Student studentForEdit = studentService.editStudent(student); // переменная
        if(studentForEdit == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // запрос неверный, в данном случает ответ объекта (Response Entity - bad request)
        }
        return ResponseEntity.ok(studentForEdit);// если найден. что все ок. возвращаем студента
    }
    @DeleteMapping("{Id}") // аннотация для delete
    public ResponseEntity<Student> deleteStudentInfo (@PathVariable long Id){ // аннотация для ввода Id
        Student deletedStudent = studentService.deleteStudents(Id); // переменная
        if(deletedStudent == null){
            return ResponseEntity.notFound().build(); // если нет такого Id, то исключение, в данном случает ответ объекта (Response Entity - nor found)
        }
        return ResponseEntity.ok(deletedStudent);// если найден. что все ок. возвращаем данные удаленного студента
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findStudentByAge (@RequestParam(required = false) int age){// задаем возраст и ищем студентов
        if(age > 0){
            return ResponseEntity.ok(studentService.findByAge(age));
        }
       return ResponseEntity.noContent().build();// нет контента
    }

}
