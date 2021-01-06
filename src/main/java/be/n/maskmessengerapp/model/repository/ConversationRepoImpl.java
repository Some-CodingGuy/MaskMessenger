package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
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
    public int insertConversation(UUID id, Conversation conversation) {
        String sql = "INSERT INTO conversation (conversation_id, interlocutor1_id, interlocutor2_id) VALUES (?, ?, ?)";
        UUID interlocutor1_id = conversation.getInterlocutor1_Id();
        UUID interlocutor2_id = conversation.getinterlocutor2_Id();
        jdbcTemplate.update(sql, id, interlocutor1_id, interlocutor2_id);
        return 0;
    }

    @Override
    public Optional<Conversation> selectConversationByI(UUID id) {
        String sql = "SELECT * from";
        return null;
    }

    @Override
    public int deleteConversationById(UUID id) {
        return 0;
    }
}
