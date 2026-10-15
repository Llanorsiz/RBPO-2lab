package kurban.softwareProducts.softwareProduct.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateSoftwareProductRequest {
    private String name;
    private Long responsibleUserId;
}
