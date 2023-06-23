package shopUnsecured.shopUnsecured.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;

    @ManyToOne
        @JoinColumn(name = "orderId")
    private Order order;
  //  private int orderId;

    @ManyToOne
    @JoinColumn(name = "productId") // Name of the foreign key column
    private Product product;
    private int quantity;
    private double itemAmount;

    public OrderItem(Order order, Product product, int quantity, double itemAmount) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.itemAmount = itemAmount;
    }
    public OrderItem(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.itemAmount = product.getPrice()*quantity;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }
}

