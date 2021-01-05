package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Conversation {

    @JsonProperty("conversation_id")
    private UUID conversationId;
    @JsonProperty("interlocutor1_id")
    private UUID interlocutor1_Id;
    @JsonProperty("interlocutor2_Id")
    private UUID interlocutor2_Id;

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getInterlocutor1_Id() {
        return interlocutor1_Id;
    }

    public void setInterlocutor1_Id(UUID interlocutorId) {
        this.interlocutor1_Id = interlocutorId;
    }

    public UUID getinterlocutor2_Id() {
        return interlocutor2_Id;
    }

    public void setinterlocutor2_Id(UUID interlocutor2_Id) {
        this.interlocutor2_Id = interlocutor2_Id;
    }
}
