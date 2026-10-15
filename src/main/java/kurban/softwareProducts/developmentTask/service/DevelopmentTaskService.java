package kurban.softwareProducts.developmentTask.service;

import kurban.softwareProducts.developmentTask.model.DevelopmentTask;
import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevelopmentTaskService {
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<DevelopmentTask> getDevelopmentTasks() {
        return developmentTaskRepository.findAll();
    }

    public DevelopmentTask createDevelopmentTask(DevelopmentTask task) {
        task.setId(null);
        developmentTaskRepository.save(task);
        return task;
    }

    public DevelopmentTask updateDevelopmentTask(Long developmentTaskId, DevelopmentTask task) {
        task.setId(developmentTaskId);
        developmentTaskRepository.save(task);
        return task;
    }

    public void deleteDevelopmentTask(Long developmentTaskId) {
        developmentTaskRepository.deleteById(developmentTaskId);
    }
}