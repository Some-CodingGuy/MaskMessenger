package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, UUID> {

}
