package kurban.softwareProducts.softwareProduct.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.repository.ReleaseRepository;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import kurban.softwareProducts.softwareProduct.mapper.SoftwareProductMapper;
import kurban.softwareProducts.softwareProduct.model.SoftwareProduct;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import kurban.softwareProducts.softwareProduct.web.request.CreateSoftwareProductRequest;
import kurban.softwareProducts.softwareProduct.web.request.UpdateSoftwareProductRequest;
import kurban.softwareProducts.softwareProduct.web.response.SoftwareProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareProductService {
    private final SoftwareProductMapper softwareProductMapper;

    private final SoftwareProductRepository softwareProductRepository;
    private final ReleaseRepository releaseRepository;
    private final ReleaseCheckRepository releaseCheckRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<SoftwareProductResponse> getSoftwareProducts() {
        return softwareProductRepository.findAll()
                .stream()
                .map(softwareProductMapper::toSoftwareProductResponse)
                .toList();
    }

    @Transactional
    public SoftwareProductResponse createSoftwareProduct(CreateSoftwareProductRequest request) {
        SoftwareProduct softwareProduct = softwareProductMapper.fromCreateSoftwareProductRequest(request);
        softwareProductRepository.save(softwareProduct);
        return softwareProductMapper.toSoftwareProductResponse(softwareProduct);
    }

    @Transactional
    public SoftwareProductResponse updateSoftwareProduct(Long softwareProductId, UpdateSoftwareProductRequest request) {
        SoftwareProduct softwareProduct = softwareProductRepository.findById(softwareProductId).get();
        softwareProductMapper.updateFromUpdateSoftwareProductRequest(request, softwareProduct);
        return softwareProductMapper.toSoftwareProductResponse(softwareProduct);
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