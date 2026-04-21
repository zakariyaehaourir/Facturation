package ma.ehei.facturation.service;

import ma.ehei.facturation.model.Transaction;

import java.util.Optional;

public interface TransactionService {
    Transaction saveTransaction(Transaction t);
    int updateTransaction(Transaction t);
    int deleteTransaction(Transaction t);

    Transaction getById(Long id);

}
