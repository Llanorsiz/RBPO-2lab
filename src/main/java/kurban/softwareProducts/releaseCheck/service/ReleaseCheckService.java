package kurban.softwareProducts.releaseCheck.service;

import kurban.softwareProducts.releaseCheck.mapper.ReleaseCheckMapper;
import kurban.softwareProducts.releaseCheck.model.ReleaseCheck;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import kurban.softwareProducts.releaseCheck.web.request.CreateReleaseCheckRequest;
import kurban.softwareProducts.releaseCheck.web.request.UpdateReleaseCheckRequest;
import kurban.softwareProducts.releaseCheck.web.response.ReleaseCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReleaseCheckService {
    private final ReleaseCheckMapper releaseCheckMapper;

    private final ReleaseCheckRepository releaseCheckRepository;

    public List<ReleaseCheckResponse> getReleaseChecks() {
        return releaseCheckRepository.findAll()
                .stream()
                .map(releaseCheckMapper::toReleaseCheckResponse)
                .toList();
    }

    @Transactional
    public ReleaseCheckResponse createReleaseCheck(CreateReleaseCheckRequest request) {
        ReleaseCheck releaseCheck = releaseCheckMapper.fromCreateReleaseCheckRequest(request);
        releaseCheckRepository.save(releaseCheck);
        return releaseCheckMapper.toReleaseCheckResponse(releaseCheck);
    }

    @Transactional
    public ReleaseCheckResponse updateReleaseCheck(Long releaseCheckId, UpdateReleaseCheckRequest request) {
        ReleaseCheck releaseCheck = releaseCheckRepository.findById(releaseCheckId).get();
        releaseCheckMapper.updateFromUpdateReleaseCheckRequest(request, releaseCheck);
        return releaseCheckMapper.toReleaseCheckResponse(releaseCheck);
    }

    @Transactional
    public void deleteReleaseCheck(Long releaseCheckId) {
        releaseCheckRepository.deleteById(releaseCheckId);
    }
}
