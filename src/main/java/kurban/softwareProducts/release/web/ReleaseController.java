package kurban.softwareProducts.release.web;

import kurban.softwareProducts.release.service.ReleaseService;
import kurban.softwareProducts.release.web.request.CreateReleaseRequest;
import kurban.softwareProducts.release.web.request.UpdateReleaseRequest;
import kurban.softwareProducts.release.web.response.ReleaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/releases")
@RequiredArgsConstructor
public class ReleaseController {
    private final ReleaseService releaseService;

    @GetMapping
    public List<ReleaseResponse> getReleases() {
        return releaseService.getReleases();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReleaseResponse createRelease(@RequestBody CreateReleaseRequest request) {
        return releaseService.createRelease(request);
    }

    @PutMapping("/{releaseId}")
    public ReleaseResponse updateRelease(@PathVariable Long releaseId, @RequestBody UpdateReleaseRequest request) {
        return releaseService.updateRelease(releaseId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{releaseId}")
    public void deleteRelease(@PathVariable Long releaseId) {
        releaseService.deleteRelease(releaseId);
    }
}
