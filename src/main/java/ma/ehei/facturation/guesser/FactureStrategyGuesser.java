package ma.ehei.facturation.guesser;

import ma.ehei.facturation.strategy.Remise;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FactureStrategyGuesser {

    private Map<String , Remise> strategies;

    public FactureStrategyGuesser(List<Remise> remiseList){
        this.strategies = remiseList.stream().collect(
                Collectors.toMap(stra-> stra.getIdentifiant(), stra->stra)
        );
    }

    public Remise guessStrategy(String identifiantStrategy)throws RuntimeException{
        Remise strategy = this.strategies.get(identifiantStrategy);
        if(strategy == null)
            throw new IllegalArgumentException("identifiant de strategy inco");
        return strategy;
    }


}
