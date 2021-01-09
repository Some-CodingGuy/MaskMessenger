package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/* Temp substitute of User to test some new implementations */

public class User {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("active")
    private boolean active;
    @JsonProperty("roles")
    private String roles;

    public User(UUID id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = true;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}