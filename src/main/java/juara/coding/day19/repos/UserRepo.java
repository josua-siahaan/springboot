package juara.coding.day19.repos;

import juara.coding.day19.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String value);
    public Optional<User> findByUsername(String value);
}
