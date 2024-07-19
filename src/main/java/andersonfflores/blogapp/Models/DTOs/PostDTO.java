package andersonfflores.blogapp.Models.DTOs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PostDTO(UUID id, String title, String body, String imgUrl, UserDTO author, List<CommentDTO> comments,
                      LocalDateTime createdAt) {
}
