package ma.ehei.facturation.service.impl;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.exception.RemiseException;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.repositoy.TransactionRepository;
import ma.ehei.facturation.service.TransactionService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public int saveTransaction(Transaction t) {
        if(t.getMontantAvant() <= 0)
            throw new RemiseException("Montant à remiser doit étre positif");
        return this.transactionRepository.save(t);
    }

    @Override
    public int updateTransaction(Transaction t) {
        if(t.getMontantAvant() <= 0)
            throw new RemiseException("Montant à remiser doit étre positif");
        return this.transactionRepository.update(t);
    }

    @Override
    public int deleteTransaction(Transaction t) {
        return this.transactionRepository.delete(t);
    }
}
