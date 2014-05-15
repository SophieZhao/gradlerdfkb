package models.database;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema = "public", name = "method")
public class Method {

    @Id
    public Long id;
    public String description;
    public Long confidence;

    public Long getConfidence() {
        return confidence;
    }

    public void setConfidence(Long confidence) {
        this.confidence = confidence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
