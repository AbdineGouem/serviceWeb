package repository;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User findByEmail(String email);
    User findById(Long id);

    User findById(String id);

    List<User> findByRole(String role);
    User save(User user);
}
