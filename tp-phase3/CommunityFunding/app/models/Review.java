package models;

import java.util.Date;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity

public class Review extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7004817305303948875L;

	@Id
	public Long id;
	
	private String content;
	
	@play.data.format.Formats .DateTime (pattern = "yyyy-MM-dd")
	private Date postDate;
	
	@ManyToOne(optional=false)
	public Project proj;
	

	@ManyToOne(optional=false)
	public User author;
	
	
	

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the postDate
	 */
	public Date getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate the postDate to set
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	
	

}
