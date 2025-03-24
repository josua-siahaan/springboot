package juara.coding.day19.repos;

import juara.coding.day19.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByUsernameContains(String username);
}
