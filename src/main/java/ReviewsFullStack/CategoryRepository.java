package ReviewsFullStack;

import java.util.Collection;

public interface CategoryRepository {

	Collection<Category> findByReviewContains(Review review); /*Spring looks at the name of the methods to generate SQL queries*/
	/* grabs any topic based on the topic name provided */
	Collection<Category> findByReviewId(Long id);/*these are just SQL queries*/
	/*this one is by ID instead of by topic*/
}
