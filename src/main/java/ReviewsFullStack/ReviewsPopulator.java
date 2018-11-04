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
		Category category = new Category("Chicken");
		category = categoryRepo.save(category);
		reviewRepo.save(new Review("The fried chicken was delicious", category));
		
		Category categoryTwo = new Category("Fish");
		categoryTwo = categoryRepo.save(categoryTwo);
		reviewRepo.save(new Review("The fish was a little fishy", categoryTwo));
		
	
	}
	
	

}
