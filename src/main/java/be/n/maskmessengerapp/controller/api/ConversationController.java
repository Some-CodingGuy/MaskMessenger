package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.ConversationService;
import be.n.maskmessengerapp.model.datamodel.Conversation;
import be.n.maskmessengerapp.model.datamodel.UUIDID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/maskmessenger/conversation")
public class ConversationController {

    private ConversationService conversationService;

    @Autowired
    public ConversationController (ConversationService conversationService){
        this.conversationService = conversationService;
    }

    @PostMapping
    public void createConversation(@RequestBody Conversation conversation){
        this.conversationService.createNewConversation(conversation);
    }

    /**
     * Search a conversation with the given Id.
     * @param id
     *          Id of the conversation that needs to be retrieved from the database
     * @return
     *          The conversation with the given Id, if it exists.
     */
    @GetMapping
    public Optional<Conversation> getConversationbyId(@RequestBody UUIDID id){
        return conversationService.getConversationFromTheDatabase(id);
    }

    /**
     * Delete the conversation that has the given Id.
     * @param id
     *          Id of the conversation that needs to be deleted.
     */
    @DeleteMapping
    public void deleteConversation(@RequestBody UUIDID id){
        conversationService.deleteConversationFromDatabase(id);
    }





}
