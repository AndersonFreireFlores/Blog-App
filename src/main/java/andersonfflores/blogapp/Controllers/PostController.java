package andersonfflores.blogapp.Controllers;

import andersonfflores.blogapp.Models.DTOs.PostDTO;
import andersonfflores.blogapp.Services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
public class PostController {

   private final PostService postService;

    public PostController(PostService service) {
        this.postService = service;
    }

    @GetMapping(value = "/post")
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/post/{id}")
    public PostDTO getPostById(@PathVariable UUID id){
        return postService.getPostById(id);
    }

    @PostMapping(value = "/post")
    public PostDTO createPost(@RequestBody PostDTO post){
        return postService.savePost(post);
    }

    @PutMapping(value = "/post/{id}")
    public PostDTO updatePost(@PathVariable UUID id, @RequestBody PostDTO post){
        return postService.updatePost(id, post);
    }

    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable UUID id){
        postService.deletePost(id);
    }
}
