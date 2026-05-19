package ma.ehei.facturation.repositoy.impl;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.repositoy.TransactionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    public Transaction save(Transaction t) {
        String sql = "INSERT INTO Transactions (date, montant_avant, montant_apres, remise_id,utilisateur_id) VALUES (?, ?, ?, ?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, t.getDate());
            ps.setObject(2, t.getMontantAvant());
            ps.setObject(3, t.getMontantApres());
            ps.setObject(4, t.getRemiseId());
            ps.setObject(5,t.getUser().getId());
            return ps;
        }, keyHolder);


        Long generatedId = keyHolder.getKey().longValue();
        t.setId(generatedId);

        return t;
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

    public Optional<Transaction> findById(Long id) {
        String sql = "SELECT id, date, montant_avant, montant_apres, remise_id FROM Transactions WHERE id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, rs -> {
            if (rs.next()) {
                Transaction t = Transaction.builder()
                        .id(rs.getLong("id"))
                        .date(rs.getTimestamp("date").toLocalDateTime())
                        .montantAvant(rs.getDouble("montant_avant"))
                        .montantApres(rs.getDouble("montant_apres"))
                        .remiseId(rs.getLong("remise_id"))
                        .build();
                return Optional.of(t);
            } else {
                return Optional.empty();
            }
        });
    }

}
