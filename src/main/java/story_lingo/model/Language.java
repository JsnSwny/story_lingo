package story_lingo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    private String code; // Use the language code as the primary key

    private String name;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<Translation> translations;

    public Language() {
    }

    // Constructor with code and name
    public Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
