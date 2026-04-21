package ma.ehei.facturation.repositoy;

import ma.ehei.facturation.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    public Transaction save(Transaction t);

    public int update(Transaction t);

    public int delete(Transaction t);

    public Optional<Transaction> findById(Long id);

    public List<Transaction> fetch();
}
