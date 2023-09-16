package at.ac.htlinn.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeName("teacher")
public class Teacher {

    public Teacher(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
