package story_lingo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Instant createdOn;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<Translation> translations;

    public Story() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}
