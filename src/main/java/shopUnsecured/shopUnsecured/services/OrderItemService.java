package shopUnsecured.shopUnsecured.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.models.OrderItem;

import shopUnsecured.shopUnsecured.models.Product;
import shopUnsecured.shopUnsecured.repositories.OrderItemRepository;
import shopUnsecured.shopUnsecured.repositories.OrderRepository;
import shopUnsecured.shopUnsecured.repositories.ProductRepository;

import java.util.List;


//in this service i wrapped  some repository calls in try catch

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;


public List<OrderItem> getAllOrderItems() {
    return orderItemRepository.findAll();
}


    public List<OrderItem> getAllOrderItemsByOrderId(int orderId) {
        return orderItemRepository.findAllByOrderOrderId(orderId);
    }

    public void createOrderItem( Integer productId, Integer orderId,Integer quantity) {

        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
           System.out.println("No order found");
            return;
        }
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            System.out.println("No product found");
            return;
        }

        OrderItem orderItem = new OrderItem(order,product,quantity);
        try {
            orderItemRepository.save(orderItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateOrder(OrderItem orderItem, int id) {
        try {
            orderItemRepository.save(orderItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteOrderItem(int id) {
        try {
            orderItemRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteAllOrderItems() {
        try {
            orderItemRepository.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
