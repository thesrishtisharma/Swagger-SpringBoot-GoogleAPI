package srishti.codeassessment.googleapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SimplifiedData {

    @Id
    private String name;

    @Column(nullable = false)
    private long unix;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String bucket;

    @Column(nullable = false)
    private String operation;

    public void setUnix() {
        this.unix = System.currentTimeMillis() / 1000L;
    }
}
