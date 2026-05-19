package ma.ehei.facturation.service;

import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.guesser.FactureStrategyGuesser;
import ma.ehei.facturation.model.Transaction;

public interface FactureService {
    public Transaction calculeMontant(Double mt , String identifiantStrategy , UserInTransactionDto userDto) throws RuntimeException;

}
