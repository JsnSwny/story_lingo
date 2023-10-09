package story_lingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import story_lingo.model.Story;
import story_lingo.repository.StoryRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @GetMapping("/")
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }


}
