package models;

import java.util.Collection;

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
	
	private String Title;
	private String Description;
	private Double rating;
	private Double TotalFund;
	private Integer counter;
	private Double target;
 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proje")
	  private Collection <Fund>  whoFundedMe;
	
	@ManyToOne (optional=false)
		private User initiator;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="proj")
		public Collection <Review> myReviews;
	
	
	public Project(){
	   TotalFund=0.0;
	   rating=0.0;
	   counter=0;
	}
	
	
	
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

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	public void rate (Integer vote){
		 rating= ((rating*counter)+vote)/(counter+1);  // can combine into single expression later :)
		 
		 counter++;
	}

	/**
	 * @return the totalFund
	 */
	public Double getTotalFund() {
		return TotalFund;
	}

	public void fund(Double amount){
		TotalFund=TotalFund+amount;
	}
	
			
  /* Not in use for now */
	public Double updateTotalFund(){
		double sum=0;
		for (Fund e : whoFundedMe) {
			sum+=e.getAmount();
			}
		TotalFund=sum;
		return TotalFund;
	}



	/**
	 * @return the target
	 */
	public Double getTarget() {
		return target;
	}



	/**
	 * @param target the target to set
	 */
	public void setTarget(Double target) {
		this.target = target;
	}
	


}
