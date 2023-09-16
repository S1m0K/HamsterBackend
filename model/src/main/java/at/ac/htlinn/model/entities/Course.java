package at.ac.htlinn.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeName("course")
public class Course {

    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<User> users;

}
