package kurban.softwareProducts.user.mapper;

import kurban.softwareProducts.user.model.User;
import kurban.softwareProducts.user.web.request.CreateUserRequest;
import kurban.softwareProducts.user.web.request.UpdateUserRequest;
import kurban.softwareProducts.user.web.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);

    User fromCreateUserRequest(CreateUserRequest request);

    void updateFromUpdateUserRequest(UpdateUserRequest request, @MappingTarget User user);
}
