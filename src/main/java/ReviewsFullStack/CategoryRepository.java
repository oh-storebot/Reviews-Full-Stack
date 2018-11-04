package ReviewsFullStack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Collection<Category> findByReviewsContains(Review review); /*Spring looks at the name of the methods to generate SQL queries*/
	/* grabs any topic based on the topic name provided */
	Collection<Category> findByReviewsId(Long id);/*these are just SQL queries*/
	/*this one is by ID instead of by topic*/
}
