package shopUnsecured.shopUnsecured.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import shopUnsecured.shopUnsecured.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import shopUnsecured.shopUnsecured.services.UserService;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
//    @Autowired
//    UserRepository userRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id") // Name of the foreign key column in the Orders table
    private User user;
    private Date orderDate;
    private double totalAmount;

    // Constructors
    protected Order() {}

//    public Order(String user, Date orderDate, double totalAmount) {
//        this.userId = new User("user","","user","");
//        this.orderDate = orderDate;
//        this.totalAmount = totalAmount;
//    }
    public Order(int id, Date orderDate, double totalAmount) {
        this.user= new User("user","","user","");
        user.setUserId(id);
        this.orderDate = new Date();;
        this.totalAmount = totalAmount;
    }
    public Order(User user, double totalAmount) {
        this.user = user;
        this.totalAmount = totalAmount;
        this.orderDate = new Date();
    }
//    public Order(int id, double totalAmount) {
//        this.user= new User("user","","user","");
//        user.setId(id);
//        this.orderDate = new Date();;
//        this.totalAmount = totalAmount;
//    }


//    public Order( double totalAmount) {
//        this.orderDate = new Date();
//        this.totalAmount = totalAmount;
//    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.setUserId(user.getUserId()); // Set the user ID for the foreign key relationship
    }
}