package andersonfflores.blogapp.Repositories;

import andersonfflores.blogapp.Models.DTOs.CommentDTO;
import andersonfflores.blogapp.Models.DTOs.UserDTO;
import andersonfflores.blogapp.Models.Post;
import andersonfflores.blogapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query(value = "SElECT tb_user.name, tb_user.email FROM tb_user WHERE tb_user.id = :id", nativeQuery = true)
    UserDTO findByUserDTOId(@Param("id")UUID userId);

    @Query(value = "SELECT comment.id, comment.body,comment.imgurl, user.name, user.email FROM comment INNER JOIN tb_user on comment.user_id = user.id " +
            "WHERE comment.post_id = :postId", nativeQuery = true)
    List<CommentDTO> findAllCommentsDTOsByPostId(UUID postId);

}
