package ai.ecma.appmultydb.Repository.Address;

import ai.ecma.appmultydb.Entity.Address.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
}
