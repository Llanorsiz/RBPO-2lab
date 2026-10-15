package kurban.softwareProducts.softwareProduct.repository;

import kurban.softwareProducts.softwareProduct.model.SoftwareProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareProductRepository extends JpaRepository<SoftwareProduct, Long> {
    boolean existsByResponsibleUserId(Long responsibleUserId);
}
