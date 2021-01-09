package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    /**
     * The new conversation will be saved to the database.
     * @param conversation
     *          New conversation that will be added to the database.
     * @return
     */
    public Conversation createNewConversation(@Qualifier("conversationJson") Conversation conversation){
        return conversationRepository.save(conversation);
    }

    /**
     * Get the conversation that has the given ID.
     * @param id
     *          ID of the conversation that has to be retrieved from the database.
     * @return
     *          Conversation with the given ID.
     */
    public Optional<Conversation> getConversationFromTheDatabase(UUID id){
        return conversationRepository.findById(id);
    }

    public String deleteConversationFromDatabase(UUID id){
        if (conversationRepository.existsById(id)){
            conversationRepository.deleteById(id);
            return "Conversation deleted.";
        }
        else {
            return "Conversation doesn't exist.";
        }
    }

}
