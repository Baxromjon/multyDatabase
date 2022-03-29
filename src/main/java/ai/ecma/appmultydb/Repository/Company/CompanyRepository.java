package ai.ecma.appmultydb.Repository.Company;

import ai.ecma.appmultydb.Entity.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
