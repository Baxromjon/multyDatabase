package ai.ecma.appmultydb.Repository.Address;

import ai.ecma.appmultydb.Entity.Address.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegionRepository extends JpaRepository<Region, UUID> {
}
