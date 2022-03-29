package ai.ecma.appmultydb.Repository.Company;

import ai.ecma.appmultydb.Entity.Company.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
}
