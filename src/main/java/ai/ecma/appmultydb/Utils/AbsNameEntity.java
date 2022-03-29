package ai.ecma.appmultydb.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class AbsNameEntity extends AbsEntity {
    @Column(nullable = false)
    private String name;
}
