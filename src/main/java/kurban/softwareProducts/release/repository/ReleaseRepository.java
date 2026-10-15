package kurban.softwareProducts.release.repository;

import kurban.softwareProducts.release.model.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
    List<Release> findByProductId(Long productId);
}