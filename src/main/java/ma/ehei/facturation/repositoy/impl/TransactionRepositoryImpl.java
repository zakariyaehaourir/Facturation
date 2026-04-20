package ma.ehei.facturation.repositoy.impl;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.repositoy.TransactionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    public int save(Transaction t){
        String sql = "INSERT INTO Transactions (date, montant_avant, montant_apres, remise_id) VALUES (?, ?, ?, ?)";
        int rowsAffected=this.jdbcTemplate.update(sql ,
                t.getDate(),
                t.getMontantAvant(),
                t.getMontantApres(),
                t.getRemiseId()
                );

        return rowsAffected;
    }

    public int update(Transaction t) {
        String sql = "UPDATE Transactions SET date = ?, montant_avant = ?, montant_apres = ?, remise_id = ? WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                t.getDate(),
                t.getMontantAvant(),
                t.getMontantApres(),
                t.getRemiseId(),
                t.getId()
        );
    }

    public int delete(Transaction t){
        String sql = "DELETE FROM Transactions WHERE id=?";
        return this.jdbcTemplate.update(sql , t.getId());
    }

    public List<Transaction> fetch(){
        return null;
    }
}
