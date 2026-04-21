package ma.ehei.facturation.service.impl;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.exception.RemiseException;
import ma.ehei.facturation.exception.TransactionNotFoundException;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.repositoy.impl.TransactionRepositoryImpl;
import ma.ehei.facturation.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepositoryImpl transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction t) {
        if(t.getMontantAvant() <= 0)
            throw new RemiseException("Montant à remiser doit étre positif");
        System.out.println(t);
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


    @Override
    public Transaction getById(Long id){
        return this.transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(
                        "Transaction  with id " + id + " Not found")
                );

    }
}
