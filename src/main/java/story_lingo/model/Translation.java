package story_lingo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @CreationTimestamp
    private Instant createdOn;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    public Translation(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Translation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
