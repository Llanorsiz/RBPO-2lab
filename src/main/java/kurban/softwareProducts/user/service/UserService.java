package kurban.softwareProducts.user.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import kurban.softwareProducts.user.mapper.UserMapper;
import kurban.softwareProducts.user.model.User;
import kurban.softwareProducts.user.repository.UserRepository;
import kurban.softwareProducts.user.web.request.CreateUserRequest;
import kurban.softwareProducts.user.web.request.UpdateUserRequest;
import kurban.softwareProducts.user.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;
    private final SoftwareProductRepository softwareProductRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        User user = userMapper.fromCreateUserRequest(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Transactional
    public UserResponse updateUser(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).get();
        userMapper.updateFromUpdateUserRequest(request, user);
        return userMapper.toUserResponse(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (softwareProductRepository.existsByResponsibleUserId(userId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "User " + userId + " is responsible for software products");
        }
        if (developmentTaskRepository.existsByAssigneeUserId(userId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "User " + userId + " is assigned to development tasks");
        }
        userRepository.deleteById(userId);
    }
}