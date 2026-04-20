package ma.ehei.facturation.repositoy.impl;

import ma.ehei.facturation.model.Remise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class RemiseRepositoryImpl implements ma.ehei.facturation.repositoy.RemiseRepository {
    private JdbcTemplate jdbcTemplate;

    public RemiseRepositoryImpl(JdbcTemplate jdbc){
        this.jdbcTemplate = jdbc;
    }

    public Remise findByBetweenMinAndMax(double max){
        String sql = "SELECT * FROM remise  WHERE montant_min <= ?  AND (montant_max >= ? OR montant_max IS NULL)";
        return jdbcTemplate.queryForObject(sql, new Object[]{max, max}, (rs, rowNum) -> {
            Remise r = new Remise().builder().
                    id(rs.getLong("id"))
                            .min(rs.getDouble("montant_min"))
                                    .max(rs.getDouble("montant_max"))
                                            .taux(rs.getDouble("taux"))

                    .build();
            return r;
        });
    }
}
