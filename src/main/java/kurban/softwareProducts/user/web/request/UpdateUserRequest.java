package kurban.softwareProducts.user.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateUserRequest {
    private String username;
}
