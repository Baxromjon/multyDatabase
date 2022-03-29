package ai.ecma.appmultydb.Repository.University;

import ai.ecma.appmultydb.Entity.University.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyRepository extends JpaRepository<Faculty, UUID> {
}
