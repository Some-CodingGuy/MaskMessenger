package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Conversation {

    @JsonProperty("interlocutorid")
    private UUID interlocutorId;
    @JsonProperty("userid")
    private UUID userID;
}
