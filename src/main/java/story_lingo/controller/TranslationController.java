package story_lingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import story_lingo.model.Translation;
import story_lingo.service.TranslationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {
    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping("/")
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        Translation createdTranslation = translationService.createTranslation(translation);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Translation> getTranslationById(@PathVariable Long id) {
        Optional<Translation> translation = translationService.getTranslationById(id);
        return translation.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public ResponseEntity<List<Translation>> getAllTranslations() {
        List<Translation> translations = translationService.getAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Translation> updateTranslation(@PathVariable Long id, @RequestBody Translation updatedTranslation) {
        Translation updated = translationService.updateTranslation(id, updatedTranslation);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslation(@PathVariable Long id) {
        translationService.deleteTranslation(id);
    }
}
