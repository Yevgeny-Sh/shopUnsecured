package shopUnsecured.shopUnsecured.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import shopUnsecured.shopUnsecured.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}