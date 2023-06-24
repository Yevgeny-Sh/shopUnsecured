package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.OrderItem;
import shopUnsecured.shopUnsecured.services.OrderItemService;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/orderItems")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @RequestMapping("/orderItems/{id}")
    public List<OrderItem> getAllOrdersItemsForOrder(@PathVariable int id) {
        return orderItemService.getAllOrderItemsByOrderId(id);
    }


    //"http://localhost:8080/orderItems?orderId=3"
    @RequestMapping(method = RequestMethod.POST, value = "/orderItems")
    public void createOrderItem(@RequestBody OrderItem orderItem, @RequestParam("orderId") int orderId,
                                @RequestParam("productId") int productId) {
        int quantity = orderItem.getQuantity();
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
