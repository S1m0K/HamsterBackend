package at.ac.htlinn.model.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "solution")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeName("solution")
public class Solution {

    public Solution(Exercise exercise, String hamster) {
        this.exercise = exercise;
        this.hamster = hamster;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Integer id;

    @Column(name = "hamster", unique = false, nullable = false)
    private String hamster;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

}
