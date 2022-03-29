package ai.ecma.appmultydb.Entity.University;

import ai.ecma.appmultydb.Utils.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.UUID;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student extends AbsEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Date birthDate;
    private String email;
    @Column(nullable = false)
    private UUID contactId;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Group group;
}
