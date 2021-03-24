package test.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.one.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
