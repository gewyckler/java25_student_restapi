package pl.javagda25.student_rest_api.service;

import org.springframework.stereotype.Service;
import pl.javagda25.student_rest_api.model.Student;
import pl.javagda25.student_rest_api.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
