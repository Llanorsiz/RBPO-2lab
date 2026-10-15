package kurban.softwareProducts.release.web.response;

import kurban.softwareProducts.release.model.ReleaseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Getter
@Builder
@Jacksonized
public class ReleaseResponse {
    private Long id;
    private String number;
    private Long productId;
    private ReleaseStatus status;
    private LocalDate createdAt;
}
