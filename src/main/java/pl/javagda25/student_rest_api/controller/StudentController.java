package pl.javagda25.student_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.javagda25.student_rest_api.model.Student;
import pl.javagda25.student_rest_api.model.dto.CreateStudentRequest;
import pl.javagda25.student_rest_api.model.dto.StudentUpdateRequest;
import pl.javagda25.student_rest_api.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudentList() {
        return studentService.getAll();
    }

    @GetMapping("{id}")
    public Student getByID(@PathVariable(name = "id") Long studentId) {
        return studentService.getById(studentId);
    }

    @PutMapping
    public Long putStudent(CreateStudentRequest student) {
        return studentService.save(student);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void postStudent(StudentUpdateRequest studentUpdateRequest) {
        studentService.update(studentUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.delete(id);

    }
}
