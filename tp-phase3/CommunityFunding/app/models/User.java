package models;

import java.util.Collection;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class User extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5854422586239724109L;
	
	@Id
	public long id;
	
	public static Finder<Long, User> find =
	        new Finder<Long,User>(Long.class, User.class);
	
	
	
	
	public byte[] picture;
	
	private String email;
	private String password;
	private Double  rating;
	private Integer counter;
	
    public User(){
		counter=0;
		rating=0.0;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="funder")
		private Collection <Fund> myfunds;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="initiator")
		private Collection <Project> myprojects;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="author")
	public Collection <Review> myReviews;

	@ManyToMany(mappedBy="myMembers")
		public Collection <Community> myCommunities;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	public void rate(Integer vote){
	 rating= ((rating*counter)+vote)/(counter+1);  // can combine into single expression later :)
	 
	 counter++;
		
	}
	
	public static User authenticate(String email,String password){
		User guest=User.find.where().eq("email",email).eq("password", password).findUnique(); 
	    return guest;
	}

	
	}
	

