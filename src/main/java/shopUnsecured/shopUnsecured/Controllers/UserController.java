package shopUnsecured.shopUnsecured.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopUnsecured.shopUnsecured.models.User;
import shopUnsecured.shopUnsecured.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.GetAllUsers();
    }

    @RequestMapping("users/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "users/{id}")
    public void updateUser(@RequestBody User user,@PathVariable int id){
        userService.updateUser(user,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

//    @RequestMapping(method = RequestMethod.DELETE,value = "users/{id}")
//    public void deleteUser(@PathVariable int id){
//        userService.deleteUser(id);
//    }

}
