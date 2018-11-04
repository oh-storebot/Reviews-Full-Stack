package ReviewsFullStack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewsPopulator implements CommandLineRunner {

	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Category category = new Category("Test category");
		category = categoryRepo.save(category);
		reviewRepo.save(new Review("This is a test review", category));
		
		Category categoryTwo = new Category("Test category Two");
		categoryTwo = categoryRepo.save(categoryTwo);
		reviewRepo.save(new Review("This is a second test review", categoryTwo));
		
	
	}
	
	

}
