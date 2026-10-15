package kurban.softwareProducts.softwareProduct.web.response;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class SoftwareProductResponse {
    private Long id;
    private String name;
    private Long responsibleUserId;
    private Long currentReleaseId;
}
