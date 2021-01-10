package be.n.maskmessengerapp.model.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UUIDID {

    @JsonProperty("id")
    private UUID id;

    public UUIDID(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
