package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;


public class User {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("about")
    private String about;

    /* Getters for the user class */

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    /* Setters for the user class */

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setAbout(String about) {
        this.about = about;
        return this;
    }
}
