package andersonfflores.blogapp.Models.DTOs;

import java.util.UUID;

public record CommentDTO(UUID id, String body, UserDTO author) {
}
