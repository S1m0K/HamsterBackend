package at.ac.htlinn.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeName("exercise")
public class Exercise {

    public Exercise(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "hamster", unique = false, nullable = false)
    private String hamster;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
