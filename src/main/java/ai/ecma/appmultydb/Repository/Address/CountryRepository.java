package ai.ecma.appmultydb.Repository.Address;

import ai.ecma.appmultydb.Entity.Address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
