package story_lingo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_posted")
    private Date dateCreated;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date datePosted) {
        this.dateCreated = datePosted;
    }
}
