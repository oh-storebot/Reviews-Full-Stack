package ReviewsFullStack;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ReviewController {

	@Resource /*Spring should provide this dependency. Used to pass this object type  */
	CategoryRepository categoryRepo;
	
	@Resource
	TopicRepository topicRepo;
	
	@RequestMapping("/course") /*for the URL*/
	public String findOneCourse(@RequestParam(value="id") long id, Model model) throws CourseNotFoundException {
		Optional<Course> course = courseRepo.findById(id);
		
		if(course.isPresent()) {
			model.addAttribute("courses", course.get());
			return "course"; /*HTML file referenced */
		}
		throw new CourseNotFoundException(); /*Spring to handle. reacts to the http status code*/
	}

	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) {

		model.addAttribute("courses", courseRepo.findAll()); /*findAll is picking up everything*/
		return("courses");
	}
	
	@RequestMapping("/topic")
	public String findOneTopic(@RequestParam(value="id") long id, Model model) throws TopicNotFoundException{
		Optional<Topic> topic = topicRepo.findById(id);
		
		if(topic.isPresent()) {
			model.addAttribute("topics", topic.get());
			model.addAttribute("courses", courseRepo.findByTopicsContains(topic.get()));
			return "topic";
		}
		throw new TopicNotFoundException();
	}
	
	@RequestMapping("/topics")
	public String findAllTopics(Model model) {
		model.addAttribute("topics", topicRepo.findAll());
		return ("topics");
	}
}
