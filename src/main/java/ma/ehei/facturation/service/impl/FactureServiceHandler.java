package ma.ehei.facturation.service.impl;

import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.guesser.FactureStrategyGuesser;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.service.FactureService;
import org.springframework.stereotype.Service;

@Service

public class FactureServiceHandler implements FactureService {

    private  final FactureStrategyGuesser strategyGuesser;

    public FactureServiceHandler(FactureStrategyGuesser guesser){
        this.strategyGuesser = guesser;
    }

    public Transaction calculeMontant(Double mt , String identifiantStrategy , UserInTransactionDto userDto) throws RuntimeException {
        return this.strategyGuesser.guessStrategy(identifiantStrategy)
                .calculateRemise(mt, userDto);
    }
}
