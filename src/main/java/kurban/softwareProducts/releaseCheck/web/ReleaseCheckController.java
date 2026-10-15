package kurban.softwareProducts.releaseCheck.web;

import kurban.softwareProducts.releaseCheck.model.ReleaseCheck;
import kurban.softwareProducts.releaseCheck.service.ReleaseCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/release-checks")
@RequiredArgsConstructor
public class ReleaseCheckController {
    private final ReleaseCheckService releaseCheckService;

    @GetMapping
    public List<ReleaseCheck> getReleaseChecks() {
        return releaseCheckService.getReleaseChecks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReleaseCheck createReleaseCheck(@RequestBody ReleaseCheck check) {
        return releaseCheckService.createReleaseCheck(check);
    }

    @PutMapping("/{releaseCheckId}")
    public ReleaseCheck updateReleaseCheck(@PathVariable Long releaseCheckId, @RequestBody ReleaseCheck check) {
        return releaseCheckService.updateReleaseCheck(releaseCheckId, check);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{releaseCheckId}")
    public void deleteReleaseCheck(@PathVariable Long releaseCheckId) {
        releaseCheckService.deleteReleaseCheck(releaseCheckId);
    }
}