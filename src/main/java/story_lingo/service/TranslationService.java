package story_lingo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import story_lingo.model.Translation;
import story_lingo.repository.TranslationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationService {
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    // Create a new translation
    public Translation createTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    // Get a translation by ID
    public Optional<Translation> getTranslationById(Long id) {
        return translationRepository.findById(id);
    }

    // Get all translations
    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    // Update an existing translation
    public Translation updateTranslation(Long id, Translation updatedTranslation) {
        Optional<Translation> existingTranslation = translationRepository.findById(id);
        if (existingTranslation.isPresent()) {
            Translation translation = existingTranslation.get();
            translation.setTitle(updatedTranslation.getTitle());
            translation.setContent(updatedTranslation.getContent());
            return translationRepository.save(translation);
        }
        return null;
    }

    // Delete a translation by ID
    public void deleteTranslation(Long id) {
        translationRepository.deleteById(id);
    }
}
