package ma.ehei.facturation.repositoy.impl;

import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.model.Utilisateur;
import ma.ehei.facturation.repositoy.UtilisateurRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    private final JdbcTemplate jdbcTemplate;
    public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Utilisateur save(Utilisateur u) {
            String sql = "INSERT INTO Utilisateur (nom, prenom) VALUES (?, ?)";

            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, u.getNom());
                ps.setObject(2, u.getPrenom());

                return ps;
            }, keyHolder);


            Long generatedId = keyHolder.getKey().longValue();
            u.setId(generatedId);

            return u;

    }

    @Override
    public Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom) {
        String sql = "SELECT id, nom, prenom FROM Utilisateurs WHERE nom = ? AND prenom = ?";

        return jdbcTemplate.query(sql, new Object[]{nom, prenom}, rs -> {
            if (rs.next()) {
                Utilisateur u = Utilisateur.builder()
                        .id(rs.getLong("id"))
                        .nom(rs.getString("nom"))
                        .prenom(rs.getString("prenom"))
                        .build();
                return Optional.of(u);
            } else {
                return Optional.empty();
            }
        });
    }
}
