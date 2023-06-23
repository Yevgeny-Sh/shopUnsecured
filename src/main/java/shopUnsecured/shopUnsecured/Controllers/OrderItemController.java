package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.Order;
import shopUnsecured.shopUnsecured.models.OrderItem;
import shopUnsecured.shopUnsecured.services.OrderItemService;
import shopUnsecured.shopUnsecured.services.OrderService;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/orderItems")
    public List<OrderItem> getAllOrderItems() {
        System.out.println("in getAllOrder items");
        return orderItemService.getAllOrderItems();
    }

//    @RequestMapping("/orderItems/{id}")
//    public List<OrderItem> getAllOrdersItemsForOrder(@PathVariable int id) {
//        System.out.println("in getAllOrdersItemsForOrder");
//        return orderItemService.getAllOrderItemsByOrderId(id);
//    }


    @RequestMapping(method = RequestMethod.POST, value = "/orderItems")
    public void createOrderItem(@RequestBody int productId,@RequestBody int quantity, @RequestParam("orderId") int orderId) {
        System.out.println("in createOrder conttroller method");
        //int x = orderItem.getProduct().getProductId();
        //orderService.createOrder(totalAmount, userId);
        orderItemService.createOrderItem(productId,orderId,quantity);
    }



    @RequestMapping(method = RequestMethod.PUT,value = "orderItems/{id}")
    public void updateOrder(@RequestBody OrderItem orderItem,@PathVariable int id){
        orderItemService.updateOrder(orderItem,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "orderItems")
    public void deleteAllOrderItems(){
        orderItemService.deleteAllOrderItems();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "orderItems/{id}")
    public void deleteOrder(@PathVariable int id){
        orderItemService.deleteOrderItem(id);
    }
}
