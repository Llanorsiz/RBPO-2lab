package kurban.softwareProducts.user.service;

import kurban.softwareProducts.developmentTask.repository.DevelopmentTaskRepository;
import kurban.softwareProducts.softwareProduct.repository.SoftwareProductRepository;
import kurban.softwareProducts.user.model.User;
import kurban.softwareProducts.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SoftwareProductRepository softwareProductRepository;
    private final DevelopmentTaskRepository developmentTaskRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        user.setId(null);
        userRepository.save(user);
        return user;
    }

    public User updateUser(Long userId, User user) {
        user.setId(userId);
        userRepository.save(user);
        return user;
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