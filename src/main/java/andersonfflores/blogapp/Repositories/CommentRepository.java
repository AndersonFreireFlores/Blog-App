package andersonfflores.blogapp.Repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaAttributeConverter {
}
