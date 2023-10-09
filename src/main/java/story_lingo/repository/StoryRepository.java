package story_lingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import story_lingo.model.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
