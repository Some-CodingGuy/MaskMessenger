package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.UUIDID;
import be.n.maskmessengerapp.model.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySQLUserRepo")
public class UserRepoImpl implements UserRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        String sql = "INSERT INTO users (id, active, password, roles, user_name) VALUES (?, ?, ?, ?, ?)";
        String password = user.getPassword();
        String roles = user.getRoles();
        String userName = user.getUserName();
        jdbcTemplate.update(sql, id, true, password, roles, userName);
        return 0;
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "SELECT * FROM users;";

        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("user_name");
            String password = "Password is hidden for security purposes";
            return new User(id, name,password);
        });
    }

    @Override
    public Optional<User> selectUserByID(UUIDID id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        User user = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id.getId()} ,
                (resultSet, i) -> {
                    UUID userID = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("user_name");
                    String password = "Password is hidden for security purposes";
                    return new User(userID, name, password);
                });
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findUserByUserName(String username) {
        return Optional.empty();
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        return 0;
    }

    @Override
    public int deleteUserById(UUIDID id) {
        return 0;
    }
}
