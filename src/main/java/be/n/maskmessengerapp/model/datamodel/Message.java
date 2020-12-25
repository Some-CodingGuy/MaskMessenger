package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("messagetext")
    private String messageText;

    /* Getters for the message class */

    public int getId() {
        return id;
    }

    public String getMessageText() {
        return messageText;
    }

    /* Setters for the message class */

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public Message setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }
}
