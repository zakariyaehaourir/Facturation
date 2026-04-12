package ma.ehei.facturation.service;

import ma.ehei.facturation.model.Transaction;

public interface TransactionService {
    int saveTransaction(Transaction t);
    int updateTransaction(Transaction t);
    int deleteTransaction(Transaction t);

}
