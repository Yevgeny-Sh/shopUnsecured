package shopUnsecured.shopUnsecured.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shopUnsecured.shopUnsecured.models.Product;
import shopUnsecured.shopUnsecured.models.User;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);

}
