package andersonfflores.blogapp.Controllers;

import andersonfflores.blogapp.Models.DTOs.CommentDTO;
import andersonfflores.blogapp.Services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentDTO getCommentById(@PathVariable UUID id){
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO comment){
        return commentService.saveComment(comment);
    }

    @PutMapping("/{id}")
    public CommentDTO updateComment(@PathVariable UUID id, @RequestBody CommentDTO comment){
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable UUID id){
        commentService.deleteComment(id);
    }

}
