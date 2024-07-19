package andersonfflores.blogapp.Models.DTOs;

import java.util.UUID;

public record UserDTO(UUID id,String name, String email) {
}
