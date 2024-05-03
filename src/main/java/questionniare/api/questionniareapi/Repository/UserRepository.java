package questionniare.api.questionniareapi.Repository;

import questionniare.api.questionniareapi.model.User ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByuserId(Integer userId);


    
}
