package ma.ehei.facturation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.JDBCType;

@Component
public class InitDatabase {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @PostConstruct
        public void init() {
            jdbcTemplate.execute("SELECT 1");
        }

}
