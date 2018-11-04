package ReviewsFullStack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{

	Collection<Category> findByCategoryId(Long id);
}
