package story_lingo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import story_lingo.model.Translation;
import story_lingo.repository.TranslationRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TranslationTest {

    @Autowired
    private TranslationRepository translationRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testCreatedAtInitialization() {
        // Create a new Translation entity
        Translation translation = new Translation();
        translation.setTitle("Test Title");
        translation.setContent("Test Content");

        // Save the entity to the database
        translationRepository.save(translation);

        // Ensure that the createdAt field is not null after saving
        entityManager.flush(); // Flush to synchronize with the database

        assertNotNull(translation.getCreatedAt());
    }
}