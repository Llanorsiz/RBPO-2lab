package kurban.softwareProducts.releaseCheck.repository;

import kurban.softwareProducts.releaseCheck.model.ReleaseCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReleaseCheckRepository extends JpaRepository<ReleaseCheck, Long> {
    List<ReleaseCheck> findByReleaseId(Long releaseId);
}
