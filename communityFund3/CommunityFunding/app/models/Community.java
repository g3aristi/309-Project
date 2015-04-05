package models;

import java.util.ArrayList;
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
	
	public static Finder<Long, Community> find =
	        new Finder<Long,Community>(Long.class,Community.class);
	
	
	@Id
	public Long id;
	
	private String Title;
	private String Description;
	public String tags;
	
	@ManyToMany(cascade = CascadeType.ALL)
	public List<User> myMembers=new ArrayList<User>();
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="mycommunity")
	public List <Project> myprojects=new ArrayList<Project>();
	
	
	public Collection<User> getMyMembers() {
		return myMembers;
	}

	@ManyToMany(cascade = CascadeType.ALL , mappedBy="myCommunities")
	public List<Tag> myTags=new ArrayList<Tag>();

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

}
