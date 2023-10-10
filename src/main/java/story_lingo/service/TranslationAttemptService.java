package story_lingo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import story_lingo.model.Translation;
import story_lingo.model.TranslationAttempt;
import story_lingo.repository.TranslationAttemptRepository;
import story_lingo.repository.TranslationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationAttemptService {
    private final TranslationAttemptRepository translationAttemptRepository;

    @Autowired
    public TranslationAttemptService(TranslationAttemptRepository translationAttemptRepository) {
        this.translationAttemptRepository = translationAttemptRepository;
    }

    // Create a new translation
    public TranslationAttempt createTranslationAttempt(TranslationAttempt translationAttempt) {
        return translationAttemptRepository.save(translationAttempt);
    }

    // Get a translation by ID
    public Optional<TranslationAttempt> getTranslationAttemptById(Long id) {
        return translationAttemptRepository.findById(id);
    }

    // Get all translations
    public List<TranslationAttempt> getAllTranslationAttempts() {
        return translationAttemptRepository.findAll();
    }

    // Update an existing translation
//    public TranslationAttempt updateTranslationAttempt(Long id, TranslationAttempt updatedTranslationAttempt) {
//        Optional<TranslationAttempt> existingTranslationAttempt = translationAttemptRepository.findById(id);
//        if (existingTranslationAttempt.isPresent()) {
//            TranslationAttempt translationAttempt = existingTranslationAttempt.get();
//            return translationRepository.save(translation);
//        }
//        return null;
//    }

    // Delete a translation by ID
    public void deleteTranslationAttempt(Long id) {
        translationAttemptRepository.deleteById(id);
    }
}
