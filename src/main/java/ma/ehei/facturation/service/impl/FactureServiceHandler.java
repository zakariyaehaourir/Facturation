package ma.ehei.facturation.service.impl;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.guesser.FactureStrategyGuesser;
import org.springframework.stereotype.Service;

@Service

public class FactureServiceHandler {

    private  final FactureStrategyGuesser strategyGuesser;

    public FactureServiceHandler(FactureStrategyGuesser guesser){
        this.strategyGuesser = guesser;
    }

    public Double calculeMontant(Double mt , String identifiantStrategy) throws RuntimeException {
        return this.strategyGuesser.guessStrategy(identifiantStrategy)
                .calculateRemise(mt);
    }
}
