package questionniare.api.questionniareapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import questionniare.api.questionniareapi.Repository.UserRepository;
import questionniare.api.questionniareapi.model.User;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public User getUser(@PathVariable Integer userId){
        return userRepo.findByuserId(userId);
    }

    public List<User> getUsers(){
        List<User> users = userRepo.findAll();
        return users;
    }

    public String deleteUser(@PathVariable Integer userId){
        userRepo.deleteById(userId);
        return "user has been deleted";
    }

    public void  addUser( User user){
        userRepo.save(user);
    }

    public String editUser(@PathVariable Integer userId, User user){
       User existuser = userRepo.findByuserId(userId);
        existuser.setName(user.getName());
        existuser.setEmail(user.getEmail());
        existuser.setNumber(user.getNumber());
        existuser.setSurname(user.getSurname());
        userRepo.save(user);
        return user + "User has been updated";
    }
    
}
  