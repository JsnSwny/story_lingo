package story_lingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import story_lingo.model.TranslationAttempt;
import story_lingo.service.TranslationAttemptService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/translationAttempts")
public class TranslationAttemptController {
    private final TranslationAttemptService translationAttemptService;

    @Autowired
    public TranslationAttemptController(TranslationAttemptService translationAttemptService) {
        this.translationAttemptService = translationAttemptService;
    }

    @PostMapping("/")
    public ResponseEntity<TranslationAttempt> createTranslationAttempt(@RequestBody TranslationAttempt translationAttempt) {
        TranslationAttempt createdAttempt = translationAttemptService.createTranslationAttempt(translationAttempt);
        return new ResponseEntity<>(createdAttempt, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TranslationAttempt> getTranslationAttemptById(@PathVariable Long id) {
        Optional<TranslationAttempt> translationAttempt = translationAttemptService.getTranslationAttemptById(id);
        return translationAttempt.map(ta -> new ResponseEntity<>(ta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public ResponseEntity<List<TranslationAttempt>> getAllTranslationAttempts() {
        List<TranslationAttempt> translationAttempts = translationAttemptService.getAllTranslationAttempts();
        return new ResponseEntity<>(translationAttempts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslationAttempt(@PathVariable Long id) {
        translationAttemptService.deleteTranslationAttempt(id);
    }
}