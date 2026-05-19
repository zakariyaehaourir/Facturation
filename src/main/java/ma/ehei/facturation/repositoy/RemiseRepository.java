package ma.ehei.facturation.repositoy;

import ma.ehei.facturation.model.Remise;

public interface RemiseRepository {
    public Remise findByBetweenMinAndMax(double max);
    Remise save(Remise remise);
    Remise update(Remise remise);
    void delete(Remise remise);
}
