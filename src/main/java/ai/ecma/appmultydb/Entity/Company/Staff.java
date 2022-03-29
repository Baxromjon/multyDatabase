package ai.ecma.appmultydb.Entity.Company;

import ai.ecma.appmultydb.Utils.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Staff extends AbsEntity {
    private String firstName;
    private String lastName;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;

    private UUID contactId;
}
