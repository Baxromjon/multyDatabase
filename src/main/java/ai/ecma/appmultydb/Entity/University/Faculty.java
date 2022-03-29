package ai.ecma.appmultydb.Entity.University;

import ai.ecma.appmultydb.Utils.AbsNameEntity;
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
public class Faculty extends AbsNameEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private University university;
}
