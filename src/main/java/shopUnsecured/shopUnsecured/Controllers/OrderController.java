package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.models.User;
import shopUnsecured.shopUnsecured.services.OrderService;

import java.util.List;
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @RequestMapping("/orders")
//    public List<Order> getAllOrders(){
//        System.out.println("in getAllOrders");
//
//        return orderService.getAllOrders();}
//
//    @RequestMapping("orders/{id}")
//    public List<Order>  getAllOrdersForUser(@PathVariable int id){
//        System.out.println("in getAllOrdersByUser");
//        return orderService.getAllOrdersByUser(id);
//    }

    //////////////////////////

//    @RequestMapping(method = RequestMethod.POST,value = "orders")
//    public void addOrder(@RequestBody Order order){
//        orderService.addOrder(order);
//    }
//    @RequestMapping(method = RequestMethod.POST,value = "orders")
//    public void createOrder(@RequestBody double totalAmount,@PathVariable int id) {
//        System.out.println("in createOrder");
//
//        orderService.createOrder(totalAmount, id);
//    }
//@RequestMapping(method = RequestMethod.POST, value = "/orders")
//public void createOrder(@RequestBody Order order, @RequestParam("userId") int userId) {
//    System.out.println("in createOrder");
//
//    double totalAmount = order.getTotalAmount();
//    orderService.createOrder(totalAmount, userId);
//}

//    @Autowired
//    private OrderService orderService;

    @RequestMapping("/orders")
    public List<Order> getAllOrders() {
        System.out.println("in getAllOrders");
        return orderService.getAllOrders();
    }

    @RequestMapping("/orders/{id}")
    public List<Order> getAllOrdersForUser(@PathVariable int id) {
        System.out.println("in getAllOrdersByUser");
        return orderService.getAllOrdersByUser(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void createOrder(@RequestBody Order order, @RequestParam("userId") int userId) {
        System.out.println("in createOrder conttroller method");
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

