package questionniare.api.questionniareapi.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import questionniare.api.questionniareapi.Repository.UserRepository;
import questionniare.api.questionniareapi.Service.UserService;
import questionniare.api.questionniareapi.model.User;

    



@RestController
public class UserController {

    @Autowired
    private UserService userServcie;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/AllUsers")
    public List<User> getUsers(){
      return userServcie.getUsers();
    }

    @RequestMapping("/GetUser/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userServcie.getUser(userId);
    }

    @DeleteMapping("/Delete/{userId}")
    public String deleteUser(@PathVariable Integer userId){
       String user = userServcie.deleteUser(userId);
        return user + "has been deleted";
    }

    @PostMapping("/AddUser")
    public String addUser(User user){
        userServcie.addUser(user);
        userRepo.save(user);
        return "User has been saved";
    }

    @PutMapping("/Update/{userId}")
    public String editUser(@PathVariable Integer userId, User user){
        userServcie.editUser(userId, user);
        return "User has been updated";
    } 
    
}
