package andersonfflores.blogapp.Services;

import andersonfflores.blogapp.Models.Comment;
import andersonfflores.blogapp.Models.DTOs.CommentDTO;
import andersonfflores.blogapp.Repositories.CommentRepository;
import andersonfflores.blogapp.Repositories.PostRepository;
import andersonfflores.blogapp.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAllCommentsInDTO();
    }

    public CommentDTO getCommentById(UUID id) {
        return commentRepository.findById(id).map(comment ->
                new CommentDTO(
                        comment.getId(),
                        comment.getBody(),
                        comment.getImgUrl(),
                        comment.getUser().getName(),
                        comment.getUser().getEmail(),
                        comment.getPost_id().getId())).orElseThrow(
                () -> new RuntimeException("Comment not found")
        );


    }

    public CommentDTO saveComment(CommentDTO commentDTO) {
        commentRepository.save(new Comment(
                commentDTO.body(),
                commentDTO.imgUrl(),
                userRepository.findUserByEmail(commentDTO.email()),
                postRepository.findById(commentDTO.postId()).orElseThrow(
                        () -> new RuntimeException("Post not found")
                )));
        return commentDTO;
    }

    public CommentDTO updateComment(UUID id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Comment not found")
        );
        comment.setBody(commentDTO.body());
        comment.setImgUrl(commentDTO.imgUrl());
        commentRepository.save(comment);
        return commentDTO;
    }


    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }
}
