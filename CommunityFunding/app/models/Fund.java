package models;

import java.util.Date;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class Fund extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public long id;
	
	@play.data.format.Formats .DateTime (pattern = "yyyy-MM-dd")
	private Date dateoffunding;
    
	private Double Amount;

	@ManyToOne(optional = false)
	public Project proje;

	@ManyToOne(optional=false)
	public User funder;

	/**
	 * @return the dateoffunding
	 */
	public Date getDateoffunding() {
		return dateoffunding;
	}

	/**
	 * @param dateoffunding the dateoffunding to set
	 */
	public void setDateoffunding(Date dateoffunding) {
		this.dateoffunding = dateoffunding;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return Amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		Amount = amount;
	}
}




