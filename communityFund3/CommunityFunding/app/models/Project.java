package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;


@Entity
public class Project extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public static Finder<Long, Project> find =
			new Finder<Long,Project>(Long.class,Project.class);

	
	@play.data.format.Formats .DateTime (pattern = "yyyy-MM-dd")
	private Date postDate;
	
	private String Title;
	private String Description;
	private Double rating;
	private Double TotalFund;
	private Integer counter;
	private Double target;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proje")
	public List <Fund>  whoFundedMe=new ArrayList<Fund>();

	@ManyToOne (optional=false)
	private User initiator;

	@ManyToOne(optional = false)
	private Community mycommunity;
	
	
    @OneToMany(cascade=CascadeType.ALL,mappedBy="proj")
	public List <Review> myReviews=new ArrayList<Review>();

    public Project(){
		TotalFund=0.0;
		rating=0.0;
		counter=0;
	 }

    public void fund(Double amount){
		TotalFund=TotalFund+amount;
	}

	
    public void rate(Integer vote){
		rating= ((rating*counter)+vote)/(counter+1);  
        counter++;

	}
    
    public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getTarget() {
		return target;
	}

	public void setTarget(Double target) {
		this.target = target;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public User getInitiator() {
		return initiator;
	}

	public void setInitiator(User initiator) {
		this.initiator = initiator;
	}

	public Community getMycommunity() {
		return mycommunity;
	}

	public void setMycommunity(Community mycommunity) {
		this.mycommunity = mycommunity;
	}

	public Double getTotalFund() {
		return TotalFund;
	}

	public void setTotalFund(Double totalFund) {
		TotalFund = totalFund;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
