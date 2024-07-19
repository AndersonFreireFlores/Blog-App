package andersonfflores.blogapp.Repositories;

import andersonfflores.blogapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByPostId(UUID postId);

    User findUserByEmail(String email);
}
