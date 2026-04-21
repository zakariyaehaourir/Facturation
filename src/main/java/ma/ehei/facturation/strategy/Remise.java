package ma.ehei.facturation.strategy;

import ma.ehei.facturation.model.Transaction;

public interface Remise {
    Transaction calculateRemise(Double mt);
    String getIdentifiant();

}
