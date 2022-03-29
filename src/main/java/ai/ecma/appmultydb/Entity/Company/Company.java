package ai.ecma.appmultydb.Entity.Company;

import ai.ecma.appmultydb.Utils.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Company extends AbsNameEntity {
    @Column(nullable = false)
    private UUID contactId;
}
