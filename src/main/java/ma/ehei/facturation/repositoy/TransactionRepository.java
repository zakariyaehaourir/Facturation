package ma.ehei.facturation.repositoy;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    public int save(Transaction t){
        String sql = "INSERT INTO Transactions (date,montant_avant,montant_apres,remise_id)" +
                " VALUES('?,?,?,?')";
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
}
