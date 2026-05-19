package ma.ehei.facturation.strategy;

import lombok.Getter;
import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.model.Transaction;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RemiseFixStrategy implements  Remise{
    private final String identifiant="remise_fix";
    private final float taux = 0.02f;

    @Override
    public Transaction calculateRemise(Double mt, UserInTransactionDto userDto) {
        double montantApres = mt - (mt * this.taux);

        return Transaction.builder()
                .montantAvant(mt)
                .montantApres(montantApres)
                .remiseId(null)
                .build();
    }
}
