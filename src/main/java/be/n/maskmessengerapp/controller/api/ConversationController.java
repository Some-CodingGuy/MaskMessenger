package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.ConversationService;
import be.n.maskmessengerapp.model.datamodel.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/maskmessenger/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController (ConversationService conversationService){
        this.conversationService = conversationService;
    }

    /**
     * Search a conversation with the given Id.
     * @param id
     *          Id of the conversation that needs to be retrieved from the database
     * @return
     *          The conversation with the given Id, if it exists.
     */
    @GetMapping(path = "{id}")
    public Optional<Conversation> getConversationbyId(@PathVariable("id") UUID id){
        return conversationService.getConversationFromTheDatabase(id);
    }

    /**
     * Delete the conversation that has the given Id.
     * @param id
     *          Id of the conversation that needs to be deleted.
     */
    @DeleteMapping(path = "{id}")
    public void deleteConversation(@PathVariable("id") UUID id){
        conversationService.deleteConversationFromDatabase(id);
    }



}
