package alexdigioia.s6l3Bend.repositories;

import alexdigioia.s6l3Bend.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {

}
