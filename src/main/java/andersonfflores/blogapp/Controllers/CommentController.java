package andersonfflores.blogapp.Controllers;

import andersonfflores.blogapp.Models.DTOs.CommentDTO;
import andersonfflores.blogapp.Services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/comment")
    public List<CommentDTO> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping(value = "/comment/{id}")
    public CommentDTO getCommentById(@PathVariable UUID id){
        return commentService.getCommentById(id);
    }

    @PostMapping(value = "/comment")
    public CommentDTO createComment(@RequestBody CommentDTO comment){
        return commentService.saveComment(comment);
    }

    @PutMapping(value = "/comment/{id}")
    public CommentDTO updateComment(@PathVariable UUID id, @RequestBody CommentDTO comment){
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping(value = "/comment/{id}")
    public void deleteComment(@PathVariable UUID id){
        commentService.deleteComment(id);
    }

}
