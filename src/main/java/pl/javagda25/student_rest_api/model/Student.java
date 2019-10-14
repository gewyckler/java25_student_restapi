package pl.javagda25.student_rest_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity // to jest encja bazodanowa
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfBirth;

    @Formula(value = "(year(now())- year(date_of_birth))")
    private Integer age; //not null

    private boolean alive; //not null

    @Formula(value = "(SELECT AVG(g.value) from grade g where g.student_id = id)")
    private Double average; //nullable - nie ma "not null" nie jest typem prostym dlatego moze przyjac null

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE})
    private Set<Grade> gradeList;

    public Student(String name, String surName, int age, boolean alive) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.alive = alive;
    }

    public Student(Long id, String name, String surName, int age, boolean alive) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.alive = alive;
    }
}
