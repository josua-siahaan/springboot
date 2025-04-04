package juara.coding.day19.repos;

import juara.coding.day19.model.GroupMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMenuRepo extends JpaRepository<GroupMenu, Long> {
    public Page<GroupMenu> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
    public List<GroupMenu> findByNamaContainsIgnoreCase(String nama);

    public Page<GroupMenu> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);
    public List<GroupMenu> findByDeskripsiContainsIgnoreCase(String nama);
}
