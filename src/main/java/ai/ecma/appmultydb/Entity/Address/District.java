package ai.ecma.appmultydb.Entity.Address;

import ai.ecma.appmultydb.Utils.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class District extends AbsEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Region region;
}
