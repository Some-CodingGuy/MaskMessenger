package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

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
