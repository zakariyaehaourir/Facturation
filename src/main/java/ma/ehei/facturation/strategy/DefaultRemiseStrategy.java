package ma.ehei.facturation.strategy;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.repositoy.RemiseRepository;
import ma.ehei.facturation.repositoy.TransactionRepository;
import ma.ehei.facturation.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultRemiseStrategy implements Remise{

    private final RemiseRepository remiseRepository;
    private final TransactionService transactionService;

    @Override
    public Double calculateRemise(Double mt) {
        var remise=this.remiseRepository.findByBetweenMinAndMax(mt);
        this.transactionService.saveTransaction(
                new Transaction().builder().
                        remiseId(remise.getId())
                                .montantAvant(mt)
                                        .montantApres(mt * remise.getTaux())
                                                .
                        build();
        );
        return mt * remise.getTaux();
    }

    @Override
    public String getIdentifiant() {
        return "h2-database";
    }
}
