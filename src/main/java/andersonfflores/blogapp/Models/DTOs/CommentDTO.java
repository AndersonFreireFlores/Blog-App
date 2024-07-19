package andersonfflores.blogapp.Models.DTOs;

import java.util.UUID;

public record CommentDTO(UUID id, String body,String imgUrl,String name, String email, UUID postId) {
}
