package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Person;
import be.n.maskmessengerapp.model.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySQLRepo")
public class UserRepoImpl implements UserRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        String sql = "SELECT * FROM users;";

        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("user_name");
            String password = "Password is hidden for security purposes";
            return new Person(id, name,password);
        });
    }

    @Override
    public Optional<Person> selectPersonByID(UUID id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id} ,
                (resultSet, i) -> {
                    UUID personID = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("user_name");
                    String password = "Password is hidden for security purposes";
                    return new Person(personID, name, password);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }
}
