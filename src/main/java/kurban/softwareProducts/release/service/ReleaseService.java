package kurban.softwareProducts.release.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.repository.ReleaseRepository;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReleaseService {
    private final ReleaseRepository releaseRepository;
    private final SoftwareProductRepository softwareProductRepository;
    private final ReleaseCheckRepository releaseCheckRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<Release> getReleases() {
        return releaseRepository.findAll();
    }

    public Release createRelease(Release release) {
        release.setId(null);
        releaseRepository.save(release);
        return release;
    }

    public Release updateRelease(Long releaseId, Release release) {
        release.setId(releaseId);
        releaseRepository.save(release);
        return release;
    }

    @Transactional
    public void deleteRelease(Long releaseId) {
        Release release = releaseRepository.findById(releaseId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Release " + releaseId + " not found"));
        if (developmentTaskRepository.existsByReleaseId(releaseId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Release " + releaseId + " is referenced by development tasks");
        }
        releaseCheckRepository.deleteAll(releaseCheckRepository.findByReleaseId(releaseId));
        softwareProductRepository.findById(release.getProductId())
                .filter(product -> releaseId.equals(product.getCurrentReleaseId()))
                .ifPresent(product -> {
                    product.setCurrentReleaseId(null);
                    softwareProductRepository.save(product);
                });
        releaseRepository.delete(release);
    }
}