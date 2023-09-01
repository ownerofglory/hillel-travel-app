package ua.ithillel.travelapp.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.ithillel.travelapp.jdbc.mapper.UserRowMapper;
import ua.ithillel.travelapp.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@RequiredArgsConstructor
public class UserJdbcDao implements UserRepo {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    @Override
    public User save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO t_user (name, email, password) " +
                "VALUES (?, ?, ?) ";
        jdbcTemplate.update(conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            return preparedStatement;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            user.setId((Long) key);
        }
        return user;
    }

    @Override
    public User find(Long id) {
        User user = jdbcTemplate.queryForObject(
                "SELECT * FROM t_user WHERE id = ?",
                new Object[]{id},
                userRowMapper);
        return user;
    }
}
