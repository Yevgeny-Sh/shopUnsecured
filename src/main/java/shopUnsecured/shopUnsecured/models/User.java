package shopUnsecured.shopUnsecured.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    private String name;
    private String email;
    private String userType;
    private String password;
    //private String roles;


    // Constructors
    protected User() {
    }

    public User(String name, String email, String userType, String password) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.password = password;
       // this.roles = roles;
    }

    // Getters and Setters
    public Integer getUser_id() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // public String getRoles() {
   //     return roles;
   // }

    //public void setRoles(String roles) {
    //    this.roles = roles;
    //}
}
