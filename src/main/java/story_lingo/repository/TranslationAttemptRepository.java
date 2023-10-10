package story_lingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import story_lingo.model.TranslationAttempt;

public interface TranslationAttemptRepository extends JpaRepository<TranslationAttempt, Long> {
}
