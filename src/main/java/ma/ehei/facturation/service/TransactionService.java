package ma.ehei.facturation.service;

import ma.ehei.facturation.exception.RemiseException;
import ma.ehei.facturation.exception.TransactionNotFoundException;
import ma.ehei.facturation.model.Transaction;

import java.util.Optional;

public interface TransactionService {
    Transaction saveTransaction(Transaction t);
    void updateTransaction(Transaction t , Long transactionId) throws RemiseException,TransactionNotFoundException;
    void deleteTransaction(Transaction t)throws TransactionNotFoundException;

    Transaction getById(Long id);

}
