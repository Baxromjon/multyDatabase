package ai.ecma.appmultydb.Repository.University;

import ai.ecma.appmultydb.Entity.University.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
