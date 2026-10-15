package kurban.softwareProducts.release.web;

import kurban.softwareProducts.release.model.Release;
import kurban.softwareProducts.release.service.ReleaseService;
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
    public List<Release> getReleases() {
        return releaseService.getReleases();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Release createRelease(@RequestBody Release release) {
        return releaseService.createRelease(release);
    }

    @PutMapping("/{releaseId}")
    public Release updateRelease(@PathVariable Long releaseId, @RequestBody Release release) {
        return releaseService.updateRelease(releaseId, release);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{releaseId}")
    public void deleteRelease(@PathVariable Long releaseId) {
        releaseService.deleteRelease(releaseId);
    }
}
