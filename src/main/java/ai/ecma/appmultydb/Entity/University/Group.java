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
@Entity(name = "groups")
public class Group extends AbsNameEntity {

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Faculty faculty;
}
