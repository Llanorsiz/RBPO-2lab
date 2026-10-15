package kurban.softwareProducts.user.repository;

import kurban.softwareProducts.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
