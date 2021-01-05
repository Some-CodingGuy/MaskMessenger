package be.n.maskmessengerapp.model.repository;

import be.n.maskmessengerapp.model.datamodel.Conversation;

import java.util.Optional;
import java.util.UUID;

public interface ConversationRepo {

    /**
     * Insert new conversation into the database.
     * @param id
     *          Id of the conversation to be inserted in the database.
     * @param conversation
     *          Conversation to be inserted into the database.
     * @return
     *          If the conversation is added successfully, return 1, else return 0.
     */
    int insertConversation(UUID id, Conversation conversation);

    /**
     * Insert conversation without an ID, an id is automatically generated, and the conversation
     *      will be added to the database with the new generated ID.
     * @param conversation
     *          Conversation to be inserted into the database.
     * @return
     *          If the conversation is added successfully, return 1, else return 0.
     */
    default int insertConversation(Conversation conversation){
        UUID id = UUID.randomUUID();
        return insertConversation(id, conversation);
    }

    /**
     * Select the conversation from the database that has the given ID.
     * @param id
     *          ID of the conversation to be retrieved from the database.
     * @return
     *          An optional with the conversation
     */
    Optional<Conversation> selectConversationByI(UUID id);

    /**
     * Delete conversation from the database.
     * @param id
     *          ID of the conversation that has to be deleted from the database.
     * @return
     *          If the conversation is deleted successfully, return 1, else return 0.
     */
    int deleteConversationById(UUID id);
}
