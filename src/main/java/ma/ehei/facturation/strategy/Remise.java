package ma.ehei.facturation.strategy;

import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.model.Transaction;

public interface Remise {
    Transaction calculateRemise(Double mt , UserInTransactionDto userDto);
    String getIdentifiant();

}
