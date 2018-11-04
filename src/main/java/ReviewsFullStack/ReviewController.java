package ReviewsFullStack;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource /*Spring should provide this dependency. Used to pass this object type  */
	CategoryRepository categoryRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping("/category") /*for the URL*/
	public String findOneCourse(@RequestParam(value="id") long id, Model model) throws ClassNotFoundException {
		Optional<Category> category = categoryRepo.findById(id);
		
		if(category.isPresent()) {
			model.addAttribute("category", category.get());
			return "Categories"; /*HTML file referenced */
		}
		throw new ClassNotFoundException(); /*Spring to handle. reacts to the http status code*/
	}

	@RequestMapping("/show-categories")
	public String findAllCourses(Model model) {

		model.addAttribute("courses", categoryRepo.findAll()); /*findAll is picking up everything*/
		return("Categories");
	}
	
	@RequestMapping("/review")
	public String findOneTopic(@RequestParam(value="id") long id, Model model) throws ReviewNotFoundException{
		Optional<Review> review = reviewRepo.findById(id);
		
		if(review.isPresent()) {
			model.addAttribute("review", review.get());
			model.addAttribute("courses", categoryRepo.findByReviewsContains(review.get()));
			return "Review";
		}
		throw new ReviewNotFoundException();
	}
	
	@RequestMapping("/reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return ("Reviews");
	}
}
