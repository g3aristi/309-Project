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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
