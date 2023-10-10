package story_lingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StoryLingoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryLingoApplication.class, args);
    }

}
