package ma.ehei.facturation.strategy;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.model.Utilisateur;
import ma.ehei.facturation.repositoy.RemiseRepository;
import ma.ehei.facturation.repositoy.UtilisateurRepository;
import ma.ehei.facturation.service.TransactionService;
import ma.ehei.facturation.service.UtilisateurService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultRemiseStrategy implements Remise{

    private final RemiseRepository remiseRepository;
    private final TransactionService transactionService;
    private final UtilisateurService userService;
    @Override
    public Transaction calculateRemise(Double mt, UserInTransactionDto userDto) {
        var remise = this.remiseRepository.findByBetweenMinAndMax(mt);


        var user = userService.saveUser(
                Utilisateur.builder()
                        .nom(userDto.getNom())
                        .prenom(userDto.getPrenom())
                        .build()
        );


        Transaction t = Transaction.builder()
                .remiseId(remise.getId())
                .montantAvant(mt)
                .montantApres(mt - (mt * remise.getTaux()))
                .user(user)
                .build();

        return this.transactionService.saveTransaction(t);
    }
    @Override
    public String getIdentifiant() {
        return "h2-database";
    }
}
