package andersonfflores.blogapp.Repositories;

import andersonfflores.blogapp.Models.Comment;
import andersonfflores.blogapp.Models.DTOs.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    @Query(value = "SELECT comment.id, comment.body,comment.imgurl, user.name, user.email " +
            "FROM comment INNER JOIN tb_user on comment.user_id = user.id ",
            nativeQuery = true)
    List<CommentDTO> findAllCommentsInDTO();

    @Query(value= "SELECT * FROM comment WHERE post_id = :post_id", nativeQuery = true)
    List<Comment> findAllByPost_id(@Param("post_id") UUID postId);
}
