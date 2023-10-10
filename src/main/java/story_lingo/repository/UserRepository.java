package story_lingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import story_lingo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
