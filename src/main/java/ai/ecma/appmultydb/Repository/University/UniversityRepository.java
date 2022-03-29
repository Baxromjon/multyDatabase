package ai.ecma.appmultydb.Repository.University;

import ai.ecma.appmultydb.Entity.University.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {
}
