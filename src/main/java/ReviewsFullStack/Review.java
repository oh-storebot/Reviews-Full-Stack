package ReviewsFullStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Review {

	@Id /* these two lines auto generate an ID for each value in the table */
	@GeneratedValue
	private long id;
	
	private String name;
	private String description;
	
	@ManyToOne
	private Category category;
	
	
	
	public Review() {}
	
	public Review(String description, Category category) {

		this.description = description;
		this.category = category;
	}
	
	

	@Override
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
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {

		return id;
	}

	public String getName() {

		return name;
	}
	
	public String getDescription() {
		
		return description;
	}

	public Category getCategory() {

		return category;
	}

	
}
