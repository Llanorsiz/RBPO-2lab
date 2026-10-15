package kurban.softwareProducts.softwareProduct.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.repository.ReleaseRepository;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import kurban.softwareProducts.softwareProduct.model.SoftwareProduct;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareProductService {
    private final SoftwareProductRepository softwareProductRepository;
    private final ReleaseRepository releaseRepository;
    private final ReleaseCheckRepository releaseCheckRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<SoftwareProduct> getSoftwareProducts() {
        return softwareProductRepository.findAll();
    }

    public SoftwareProduct createSoftwareProduct(SoftwareProduct product) {
        product.setId(null);
        softwareProductRepository.save(product);
        return product;
    }

    public SoftwareProduct updateSoftwareProduct(Long softwareProductId, SoftwareProduct product) {
        product.setId(softwareProductId);
        softwareProductRepository.save(product);
        return product;
    }

    @Transactional
    public void deleteSoftwareProduct(Long softwareProductId) {
        List<Release> releases = releaseRepository.findByProductId(softwareProductId);
        for (Release release : releases) {
            releaseCheckRepository.deleteAll(releaseCheckRepository.findByReleaseId(release.getId()));
        }
        developmentTaskRepository.deleteAll(developmentTaskRepository.findByProductId(softwareProductId));
        releaseRepository.deleteAll(releases);
        softwareProductRepository.deleteById(softwareProductId);
    }
}