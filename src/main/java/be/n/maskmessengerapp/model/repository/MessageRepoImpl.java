package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("messagerepository")
public class MessageRepoImpl implements MessageRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageRepoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertMessage(Message message) {

        return 0;
    }

    @Override
    public Optional<Message> getMessageFromDatabase(int id) {
        String sql = "SELECT * FROM message WHERE id = ?";
        Message message = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                ((resultSet, i) -> {
                    int messageId = resultSet.getInt("id");
                    String messageText = resultSet.getString("message_text");
                    return new Message(messageId, messageText);
                })
        );
        return Optional.ofNullable(message);
    }

    @Override
    public List<Message> getAllMessagesFromDatabase() {
        return null;
    }


}
