package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.services.OrderService;

import java.util.List;
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping("/orders/{id}")
    public List<Order> getAllOrdersForUser(@PathVariable int id) {
        return orderService.getAllOrdersByUser(id);
    }

//http://localhost:8080/orders?userId=52
    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void createOrder(@RequestBody Order order, @RequestParam("userId") int userId) {
        double totalAmount = order.getTotalAmount();
        orderService.createOrder(totalAmount, userId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "orders/{id}")
    public void updateOrder(@RequestBody Order order,@PathVariable int id){
        orderService.updateOrder(order,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "orders")
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "orders/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }
}

