package ReviewsFullStack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity /*Says this class should be managed by JPA and an instance of this should be found in the db */
public class Category {

	
	@Id /* these two lines auto generate an ID for each value in the table */
	@GeneratedValue /*will auto generate*/
	private long id;
	
private String name;
	
	
	@OneToMany(mappedBy = "category") /*this to that. multiple categories one review. mapped to Review*/
	private Collection<Review> reviews;
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	

	@Override /*this method should override what is in a parent*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {

		return id;
	}

	public Object getName() {
		
		return name;
	}
	
	public Collection<Review> getReviews(){
		return reviews;
	}

}
