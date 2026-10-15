package kurban.softwareProducts.releaseCheck.service;

import kurban.softwareProducts.releaseCheck.model.ReleaseCheck;
import kurban.softwareProducts.releaseCheck.repository.ReleaseCheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReleaseCheckService {
    private final ReleaseCheckRepository releaseCheckRepository;

    public List<ReleaseCheck> getReleaseChecks() {
        return releaseCheckRepository.findAll();
    }

    public ReleaseCheck createReleaseCheck(ReleaseCheck check) {
        check.setId(null);
        releaseCheckRepository.save(check);
        return check;
    }

    public ReleaseCheck updateReleaseCheck(Long releaseCheckId, ReleaseCheck check) {
        check.setId(releaseCheckId);
        releaseCheckRepository.save(check);
        return check;
    }

    public void deleteReleaseCheck(Long releaseCheckId) {
        releaseCheckRepository.deleteById(releaseCheckId);
    }
}
