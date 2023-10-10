package story_lingo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    private String code; // Use the language code as the primary key

    private String name;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Translation> translations;

    public Language() {
    }

    // Constructor with code and name
    public Language(String code, String name) {
        this.code = code;
        this.name = name;
        this.translations = new ArrayList<>();
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

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}
