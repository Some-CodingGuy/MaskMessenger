package be.n.maskmessengerapp.controller.service;

import be.n.maskmessengerapp.model.datamodel.Conversation;
import be.n.maskmessengerapp.model.datamodel.UUIDID;
import be.n.maskmessengerapp.model.repository.ConversationRepo;
import be.n.maskmessengerapp.model.repository.ConversationRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversationService {

    private ConversationRepo conversationRepository;

    @Autowired
    public ConversationService(@Qualifier("conversationJson") ConversationRepoImpl conversationRepository){
        this.conversationRepository = conversationRepository;
    }

    /**
     * The new conversation will be saved to the database.
     * @param conversation
     *          New conversation that will be added to the database.
     * @return
     */
    public int createNewConversation(Conversation conversation){
        return conversationRepository.insertConversation(conversation);
    }

    /**
     * Get the conversation that has the given ID.
     * @param id
     *          ID of the conversation that has to be retrieved from the database.
     * @return
     *          Conversation with the given ID.
     */
    public Optional<Conversation> getConversationFromTheDatabase(UUIDID id){
        return conversationRepository.selectConversationById(id);
    }

    public String deleteConversationFromDatabase(UUIDID id){
        if (conversationRepository.existsByID(id)){
            conversationRepository.deleteConversationById(id);
            return "Conversation deleted.";
        }
        else {
            return "Conversation doesn't exist.";
        }
    }

}
