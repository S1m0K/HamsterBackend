package at.ac.htlinn.database.repositories;

import at.ac.htlinn.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(int id);

    @Query(value = "SELECT * FROM STUDENT s JOIN USERS u USING (user_id) where u.user_id=:user_id", nativeQuery = true)
    List<Student> findByUserId(@Param("user_id") long user_id);

    @Query(value = "SELECT * FROM STUDENT s JOIN USERS u USING (user_id) where u.username=:username", nativeQuery = true)
    List<Student> findByName(@Param("username") String username);
}
