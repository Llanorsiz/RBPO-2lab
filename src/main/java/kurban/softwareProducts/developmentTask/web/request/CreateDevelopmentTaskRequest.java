package kurban.softwareProducts.developmentTask.web.request;

import kurban.softwareProducts.developmentTask.model.DevelopmentTaskProgress;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateDevelopmentTaskRequest {
    private Long productId;
    private Long assigneeUserId;
    private Long releaseId;
    private DevelopmentTaskProgress progress;
}
