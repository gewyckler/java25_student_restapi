package pl.javagda25.student_rest_api.mapper;

import org.mapstruct.Mapper;
import pl.javagda25.student_rest_api.model.Student;
import pl.javagda25.student_rest_api.model.dto.CreateStudentRequest;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student createStudentFromDto(CreateStudentRequest dto);
}
