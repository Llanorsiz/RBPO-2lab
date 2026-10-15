package kurban.softwareProducts.softwareProduct.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateSoftwareProductRequest {
    private String name;
    private Long responsibleUserId;
    private Long currentReleaseId;
}
