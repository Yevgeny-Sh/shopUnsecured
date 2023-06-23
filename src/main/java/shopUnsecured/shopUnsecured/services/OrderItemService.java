package shopUnsecured.shopUnsecured.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.models.OrderItem;

import shopUnsecured.shopUnsecured.models.Product;
import shopUnsecured.shopUnsecured.repositories.OrderItemRepository;
import shopUnsecured.shopUnsecured.repositories.OrderRepository;
import shopUnsecured.shopUnsecured.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;


//    public List<OrderItem> getAllOrderItems() {
//        List<OrderItem> orderItems = new ArrayList<>();
//        System.out.println("in getAllOrderItems IN SERVICE");
//
//        orderItems.addAll(orderItemRepository.findAll());
//        System.out.println(orderItems);
//
//        return orderItems;
//    }
public List<OrderItem> getAllOrderItems() {
    return orderItemRepository.findAll();
}


//    public List<OrderItem> getAllOrderItemsByOrderId(int orderId) {
//        return orderItemRepository.findAllByOrderOrderId(orderId);
//    }
//
//
//    //    public void addOrder(Order order) {
////        OrderRepository.save(order);
////    }
    public void createOrderItem( Integer productId, Integer orderId,Integer quantity) {
        System.out.println("create Order item");

        Order order = orderRepository.findById(orderId).orElse(null);
        System.out.println(order);
        if (order == null) {
           System.out.println("No order found");
            return;
        }
        System.out.println(order.getOrderId());

        Product product = productRepository.findById(productId).orElse(null);
        System.out.println(product);
        if (order == null) {
            System.out.println("No product found");
            return;
        }

        OrderItem orderItem = new OrderItem(order,product,quantity);
        orderItemRepository.save(orderItem);
    }
//
//
    public void updateOrder(OrderItem orderItem, int id) {
        orderItemRepository.save(orderItem);

    }
    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
    public void deleteAllOrderItems() {
        orderItemRepository.deleteAll();
    }
}
