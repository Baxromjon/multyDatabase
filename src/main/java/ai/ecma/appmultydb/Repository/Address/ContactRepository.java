package ai.ecma.appmultydb.Repository.Address;

import ai.ecma.appmultydb.Entity.Address.Contact;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
