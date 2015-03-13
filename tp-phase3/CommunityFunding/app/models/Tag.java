package models;



import javax.persistence.*;

import play.db.ebean.Model;



@Entity
public class Tag extends Model {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 3820753350915031629L;

@Id
public Long id;




public static Finder<Long, Tag> find =
new Finder<Long,Tag>(Long.class,Tag.class);

private String name;

@ManyToOne
public Community community;

		



/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}




}
