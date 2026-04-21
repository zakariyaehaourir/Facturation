package ma.ehei.facturation.strategy;

import lombok.Getter;

import ma.ehei.facturation.model.Transaction;
import org.springframework.stereotype.Component;
@Getter
@Component

public class RemiseVariableStrategy implements Remise{

    private final String identifiant = "remise_variable";

    @Override
    public Transaction calculateRemise(Double mt) {
        double taux = (mt > 1000) ? 0.20 : 0.05;
        double montantApres = mt - (mt * taux);

        return Transaction.builder()
                .montantAvant(mt)
                .montantApres(montantApres)
                .remiseId(null)
                .build();
    }
}
