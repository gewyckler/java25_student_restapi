package pl.javagda25.student_rest_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grade {
    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    private double value;

    //@ToString.Exclude //z lomboka, ignoruje to pole przy wypisywaniu przez toString
    @JsonBackReference
    @ManyToOne()
    private Student student;
}
