package ua.ithillel.travelapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.ithillel.travelapp.jdbc.mapper.UserRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcTestConfig extends DataSourceConfigParent {
    @Bean
    public JdbcTemplate jdbcTemplate() {
        DataSource datasource = createH2Datasource();

        return new JdbcTemplate(datasource);
    }

    @Bean
    public UserRowMapper rowMapper() {
        return new UserRowMapper();
    }
}
