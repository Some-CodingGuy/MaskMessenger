package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Conversation;
import be.n.maskmessengerapp.model.datamodel.UUIDID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository("conversationJson")
public class ConversationRepoImpl implements ConversationRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConversationRepoImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean existsByID(UUIDID id){
        Optional<Conversation> convo = selectConversationById(id);
        if (convo.isEmpty()) return false;
        else return true;
    }


    @Override
    public int insertConversation(UUID id, Conversation conversation) {
        String sql = "INSERT INTO conversation (conversation_id, interlocutor1_id, interlocutor2_id) VALUES (?, ?, ?)";
        UUID interlocutor1_id = conversation.getInterlocutor1_Id();
        UUID interlocutor2_id = conversation.getinterlocutor2_Id();
        jdbcTemplate.update(sql, id, interlocutor1_id, interlocutor2_id);
        return 0;
    }

    @Override
    public Optional<Conversation> selectConversationById(UUIDID id) {
        String sql = "SELECT * FROM conversation WHERE id = ?";
        Conversation conversation = jdbcTemplate.queryForObject(
                sql, new Object[]{id},
                ((resultSet, i) -> {
                    UUID conversationID = UUID.fromString(resultSet.getString("conversation_id"));
                    UUID interlocutor1ID = UUID.fromString(resultSet.getString("interlocutor1_id"));
                    UUID interlocutor2ID = UUID.fromString(resultSet.getString("interlocutor2_id"));
                    return new Conversation(conversationID, interlocutor1ID, interlocutor2ID);
                })
        );
        return Optional.ofNullable(conversation);
    }

    @Override
    public int deleteConversationById(UUIDID id) {
        String sql = "DELETE FROM conversation WHERE conversation_id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

}
