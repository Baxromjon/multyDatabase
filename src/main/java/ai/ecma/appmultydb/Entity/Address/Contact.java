package ai.ecma.appmultydb.Entity.Address;

import ai.ecma.appmultydb.Utils.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.awt.*;

/**
 * created by Baxromjon
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact extends AbsEntity {

    private String street;
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private District district;
}
