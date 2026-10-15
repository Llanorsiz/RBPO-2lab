package kurban.softwareProducts.user.web.response;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UserResponse {
    private Long id;
    private String username;
}
