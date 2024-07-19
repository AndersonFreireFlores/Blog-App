package andersonfflores.blogapp.Controllers;

import andersonfflores.blogapp.Models.DTOs.PostDTO;
import andersonfflores.blogapp.Services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/post")
public class PostController {

   private final PostService postService;

    public PostController(PostService service) {
        this.postService = service;
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable UUID id){
        return postService.getPostById(id);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO post){
        return postService.savePost(post);
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable UUID id, @RequestBody PostDTO post){
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id){
        postService.deletePost(id);
    }
}
