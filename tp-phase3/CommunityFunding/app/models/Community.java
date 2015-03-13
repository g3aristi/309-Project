package models;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class Community extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8130648870798216586L;

	
	
	@Id
	public Long id;
	
	private String Title;
	private String Description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<User> myMembers;
	
	
	
	
	
	public Collection<User> getMyMembers() {
		return myMembers;
	}

	/* maximum number of tags can be 3 */
	@OneToMany(mappedBy="community",cascade=CascadeType.ALL)
	public List<Tag> myTags;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	

}
