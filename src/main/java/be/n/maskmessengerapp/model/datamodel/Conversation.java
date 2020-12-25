package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Conversation {

    @Id
    private UUID conversationId;
    @JsonProperty("interlocutorid")
    private UUID interlocutorId;
    @JsonProperty("userid")
    private UUID userID;

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getInterlocutorId() {
        return interlocutorId;
    }

    public void setInterlocutorId(UUID interlocutorId) {
        this.interlocutorId = interlocutorId;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
