package kurban.softwareProducts.developmentTask.web.response;

import kurban.softwareProducts.developmentTask.model.DevelopmentTaskProgress;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class DevelopmentTaskResponse {
    private Long id;
    private Long productId;
    private Long assigneeUserId;
    private Long releaseId;
    private DevelopmentTaskProgress progress;
}
