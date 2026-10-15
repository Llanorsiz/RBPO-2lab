package kurban.softwareProducts.developmentTask.web;

import kurban.softwareProducts.developmentTask.model.DevelopmentTask;
import kurban.softwareProducts.developmentTask.service.DevelopmentTaskService;
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
    public List<DevelopmentTask> getDevelopmentTasks() {
        return developmentTaskService.getDevelopmentTasks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DevelopmentTask createDevelopmentTask(@RequestBody DevelopmentTask task) {
        return developmentTaskService.createDevelopmentTask(task);
    }

    @PutMapping("/{developmentTaskId}")
    public DevelopmentTask updateDevelopmentTask(@PathVariable Long developmentTaskId, @RequestBody DevelopmentTask task) {
        return developmentTaskService.updateDevelopmentTask(developmentTaskId, task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{developmentTaskId}")
    public void deleteDevelopmentTask(@PathVariable Long developmentTaskId) {
        developmentTaskService.deleteDevelopmentTask(developmentTaskId);
    }
}