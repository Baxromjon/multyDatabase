package ai.ecma.appmultydb.Repository.University;

import ai.ecma.appmultydb.Entity.University.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
