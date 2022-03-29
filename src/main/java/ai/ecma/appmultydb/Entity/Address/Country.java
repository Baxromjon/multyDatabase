package ai.ecma.appmultydb.Entity.Address;

import ai.ecma.appmultydb.Utils.AbsEntity;
import ai.ecma.appmultydb.Utils.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)

@Data
@Entity
public class Country extends AbsNameEntity {
}
