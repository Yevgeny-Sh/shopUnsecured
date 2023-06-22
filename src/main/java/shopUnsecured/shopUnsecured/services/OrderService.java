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

        OrderRepository.findByUserId(id).forEach(orders::add);
        return orders;
    }


    public void addOrder(Order order) {
        OrderRepository.save(order);
    }
    public void createOrder(double totalAmount, Integer userId) {
        System.out.println("createOrder");

        User user = userRepository.getById(userId);
        System.out.println(user);

        if (user == null) {
            System.out.println("No user found");
            return; // or throw an exception if appropriate
        }

        System.out.println(user.getUserId());

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

