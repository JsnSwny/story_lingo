package story_lingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import story_lingo.model.Translation;

import java.util.List;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findTranslationsByStoryId(Long storyId);
}
