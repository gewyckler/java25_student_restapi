package pl.javagda25.student_rest_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @CreationTimestamp
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    private double value;

    //@ToString.Exclude //z lomboka, ignoruje to pole przy wypisywaniu przez toString
    @JsonBackReference
    @ManyToOne()
    private Student student;

    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }
}
