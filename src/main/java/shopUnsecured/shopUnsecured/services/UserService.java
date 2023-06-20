package shopUnsecured.shopUnsecured.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopUnsecured.shopUnsecured.models.User;
import shopUnsecured.shopUnsecured.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired
    private UserRepository userRepository;

//    List<User> users =new ArrayList<>( Arrays.asList(
////            new User(1, "ff", "1", "1"),
////            new User(2, "qqq", "qq", "qqq")
//    ));


    public List<User> GetAllUsers() {
        List<User> users=new ArrayList<>();
         userRepository.findAll().forEach(users::add);
         return users;
    }

    public User getUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); // or throw an exception if necessary
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user, int id) {
        userRepository.save(user);

    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }




}