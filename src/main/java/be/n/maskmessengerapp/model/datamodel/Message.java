package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String sendername;
    private String messagetext;


    /* Getters for the message class */

    public int getId() {
        return id;
    }

    public String getSenderName() {
        return sendername;
    }

    public String getMessageText() {
        return messagetext;
    }

    /* Setters for the message class */

    public void setId(int id) {
        this.id = id;
    }

    public void setSenderName(String senderName) {
        this.sendername = senderName;
    }

    public void setMessageText(String messageText) {
        this.messagetext = messageText;
    }

}
