package pl.javagda25.student_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javagda25.student_rest_api.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
