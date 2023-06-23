package shopUnsecured.shopUnsecured.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shopUnsecured.shopUnsecured.models.OrderItem;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
     //List<OrderItem> findAllByOrderOrderId(int orderId);
}
