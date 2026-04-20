package ma.ehei.facturation.service;

import ma.ehei.facturation.guesser.FactureStrategyGuesser;

public interface FactureService {
    public Double calculeMontant(Double mt , String identifiantStrategy) throws RuntimeException;

}
