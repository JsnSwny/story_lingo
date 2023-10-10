package story_lingo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import story_lingo.model.Story;
import story_lingo.repository.StoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

//    Create a new story
    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public Optional<Story> getStoryById(Long id) {
        return storyRepository.findById(id);
    }

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public void deleteStory(Long id) {
        storyRepository.deleteById(id);
    }
}
