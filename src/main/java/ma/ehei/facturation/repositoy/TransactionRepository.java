package ma.ehei.facturation.repositoy;

import ma.ehei.facturation.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    public int save(Transaction t);

    public int update(Transaction t);

    public int delete(Transaction t);

    public List<Transaction> fetch();
}
