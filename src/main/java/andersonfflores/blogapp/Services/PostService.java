package andersonfflores.blogapp.Services;

import andersonfflores.blogapp.Models.DTOs.PostDTO;
import andersonfflores.blogapp.Models.Post;
import andersonfflores.blogapp.Repositories.CommentRepository;
import andersonfflores.blogapp.Repositories.PostRepository;
import andersonfflores.blogapp.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(post ->
                new PostDTO(post.getId(),
                        post.getTitle(),
                        post.getBody(),
                        post.getImgUrl(),
                        postRepository.findByUserDTOId(post.getUser().getId()),
                        postRepository.findAllCommentsDTOsByPostId(post.getId()),
                        post.getCreatedAt())).toList();
    }


    public PostDTO getPostById(UUID id) {
        return postRepository.findById(id).map(post ->
                new PostDTO(post.getId(),
                        post.getTitle(),
                        post.getBody(),
                        post.getImgUrl(),
                        postRepository.findByUserDTOId(post.getUser().getId()),
                        postRepository.findAllCommentsDTOsByPostId(post.getId()),
                        post.getCreatedAt())).orElse(null);
    }

    public PostDTO savePost(PostDTO postDTO){
        postRepository.save(new Post(
                postDTO.title(),
                postDTO.body(),
                postDTO.imgUrl(),
                postRepository.findUserByPostId(postDTO.author().id()),
                commentRepository.findAllByPost_id(postDTO.id()),
                postDTO.createdAt()
        ));
        return postDTO;
    }

    public PostDTO updatePost(UUID id, PostDTO postDTO){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Post not found")
        );
        post.setTitle(postDTO.title());
        post.setBody(postDTO.body());
        post.setImgUrl(postDTO.imgUrl());
        post.setUser(postRepository.findUserByPostId(postDTO.author().id()));
        post.setComments(commentRepository.findAllByPost_id(postDTO.id()));
        postRepository.save(post);
        return postDTO;
    }

    public void deletePost(UUID id){
        postRepository.deleteById(id);
    }


}
