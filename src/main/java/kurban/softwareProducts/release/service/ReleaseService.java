package kurban.softwareProducts.release.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.release.mapper.ReleaseMapper;
import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.repository.ReleaseRepository;
import kurban.softwareProducts.release.web.request.CreateReleaseRequest;
import kurban.softwareProducts.release.web.request.UpdateReleaseRequest;
import kurban.softwareProducts.release.web.response.ReleaseResponse;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReleaseService {
    private final ReleaseMapper releaseMapper;

    private final ReleaseRepository releaseRepository;
    private final SoftwareProductRepository softwareProductRepository;
    private final ReleaseCheckRepository releaseCheckRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<ReleaseResponse> getReleases() {
        return releaseRepository.findAll()
                .stream()
                .map(releaseMapper::toReleaseResponse)
                .toList();
    }

    @Transactional
    public ReleaseResponse createRelease(CreateReleaseRequest request) {
        Release release = releaseMapper.fromCreateReleaseRequest(request);
        release.setCreatedAt(LocalDate.now());
        releaseRepository.save(release);
        return releaseMapper.toReleaseResponse(release);
    }

    @Transactional
    public ReleaseResponse updateRelease(Long releaseId, UpdateReleaseRequest request) {
        Release release = releaseRepository.findById(releaseId).get();
        releaseMapper.updateFromUpdateReleaseRequest(request, release);
        return releaseMapper.toReleaseResponse(release);
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