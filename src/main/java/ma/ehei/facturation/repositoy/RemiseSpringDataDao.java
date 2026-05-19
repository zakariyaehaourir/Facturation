package ma.ehei.facturation.repositoy;

import ma.ehei.facturation.model.Remise;
import org.springframework.data.repository.CrudRepository;

public interface RemiseSpringDataDao extends CrudRepository< Remise, Long> {
    Remise findByMinLessThanEqualAndMaxGreaterThanEqual(double min, double max);
}
