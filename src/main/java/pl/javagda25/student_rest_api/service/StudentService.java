package pl.javagda25.student_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javagda25.student_rest_api.mapper.StudentMapper;
import pl.javagda25.student_rest_api.model.Student;
import pl.javagda25.student_rest_api.model.dto.CreateStudentRequest;
import pl.javagda25.student_rest_api.model.dto.StudentUpdateRequest;
import pl.javagda25.student_rest_api.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long studentId) {
        Optional<Student> optional = studentRepository.findById(studentId);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("student, id " + studentId);
    }

    public Long save(CreateStudentRequest dto) {
        Student student = studentMapper.createStudentFromDto(dto);

        return studentRepository.save(student).getId();
    }

    public void update(StudentUpdateRequest studentToEdit) {
        Optional<Student> optional = studentRepository.findById(studentToEdit.getStudentId());
        if (optional.isPresent()) {
            Student student = optional.get();

            if (studentToEdit.getName() != null) {
                student.setName(studentToEdit.getName());
            }
            if (studentToEdit.getSurName() != null) {
                student.setSurName(studentToEdit.getSurName());

            }
            if (studentToEdit.getDateOfBirth() != null) {
                student.setDateOfBirth(studentToEdit.getDateOfBirth());
            }
            if (studentToEdit.getAlive() != null) {
                student.setAlive(studentToEdit.getAlive());

            }
            studentRepository.save(student);
            return;
        }
        throw new EntityNotFoundException("student, id " + studentToEdit.getStudentId());
    }

    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("student, id " + id);

    }
}
