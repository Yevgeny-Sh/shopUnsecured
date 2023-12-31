package shopUnsecured.shopUnsecured.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.models.User;
import shopUnsecured.shopUnsecured.repositories.OrderRepository;
import shopUnsecured.shopUnsecured.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders() {
        List<Order> orders=new ArrayList<>();
        orders.addAll(OrderRepository.findAll());
        return orders;
    }


    public List<Order> getAllOrdersByUser(Integer id) {
        List<Order> orders=new ArrayList<>();

        orders.addAll(OrderRepository.findByUserId(id));
        return orders;
    }

    public void createOrder(double totalAmount, int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            System.out.println("No user found");
            return;
        }
        Order order = new Order(user, totalAmount);
        OrderRepository.save(order);
    }

    public void updateOrder(Order order, int id) {
        OrderRepository.save(order);

    }
    public void deleteOrder(int id) {
        OrderRepository.deleteById(id);
    }
    public void deleteAllOrders() {
        OrderRepository.deleteAll();
    }
}

