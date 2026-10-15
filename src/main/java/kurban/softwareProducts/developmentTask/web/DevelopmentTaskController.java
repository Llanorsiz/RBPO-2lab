package kurban.softwareProducts.developmentTask.web;

import kurban.softwareProducts.developmentTask.service.DevelopmentTaskService;
import kurban.softwareProducts.developmentTask.web.request.CreateDevelopmentTaskRequest;
import kurban.softwareProducts.developmentTask.web.request.UpdateDevelopmentTaskRequest;
import kurban.softwareProducts.developmentTask.web.response.DevelopmentTaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/development-tasks")
@RequiredArgsConstructor
public class DevelopmentTaskController {
    private final DevelopmentTaskService developmentTaskService;

    @GetMapping
    public List<DevelopmentTaskResponse> getDevelopmentTasks() {
        return developmentTaskService.getDevelopmentTasks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DevelopmentTaskResponse createDevelopmentTask(@RequestBody CreateDevelopmentTaskRequest request) {
        return developmentTaskService.createDevelopmentTask(request);
    }

    @PutMapping("/{developmentTaskId}")
    public DevelopmentTaskResponse updateDevelopmentTask(@PathVariable Long developmentTaskId, @RequestBody UpdateDevelopmentTaskRequest request) {
        return developmentTaskService.updateDevelopmentTask(developmentTaskId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{developmentTaskId}")
    public void deleteDevelopmentTask(@PathVariable Long developmentTaskId) {
        developmentTaskService.deleteDevelopmentTask(developmentTaskId);
    }
}