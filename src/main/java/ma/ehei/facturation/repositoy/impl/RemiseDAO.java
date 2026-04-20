package ma.ehei.facturation.repositoy.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RemiseDAO {
    private final JdbcTemplate jdbcTemplate;

    public RemiseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Retourne le nombre de lignes dans la table remise
    public int countRemises() {
        String sql = "SELECT COUNT(*) FROM remise";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
