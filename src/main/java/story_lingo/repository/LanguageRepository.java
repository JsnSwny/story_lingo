package story_lingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import story_lingo.model.Language;

public interface LanguageRepository extends JpaRepository<Language, String> {
}
