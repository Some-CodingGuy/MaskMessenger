package be.n.maskmessengerapp.controller.api;

import be.n.maskmessengerapp.controller.service.MessageService;
import be.n.maskmessengerapp.model.datamodel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maskmessenger/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController (MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public Optional<Message> getMessageById(int id){
        return messageService.getMessageFromDatabase(id);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAllMessagesFromDatabase();
    }

    @PostMapping
    public void saveMessage(Message message){
        messageService.saveMessageToDatabase(message);
    }


}
