package shopUnsecured.shopUnsecured.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shopUnsecured.shopUnsecured.models.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

     List<Order> findByUserUserId(Integer id);
}
