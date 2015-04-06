package controllers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import models.*;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import views.html.*;


class SampleCommunity{
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public SampleCommunity(Long id, String title, String description,
			String tags) {
		super();
		this.id = id;
		Title = title;
		Description = description;
		this.tags = tags;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Long id;
	private String Title;
	private String Description;
	public String tags;
}


/**
 * @author nariman mammadli
 *
 */
public class Application extends Controller {

	private static final Form<Application.Login> LoginForm =
			Form.form(Application.Login.class);
	private static final Form <User> UserForm=
			Form.form(User.class);
	private static final Form <Community> CommunityForm=
			Form.form(Community.class);

	private static final Form<Project> ProjectForm=
			Form.form(Project.class);


	private static final Form<Fund> FundForm=
			Form.form(Fund.class);


	@Security.Authenticated(Secured.class)	

	public static Result index(){
		User user=User.find.byId(Long.valueOf(session().get("id")));

		return ok(index.render(user));
	}


	
	/* This function gives detailed information about how well the project is raising funds */
     public static Result fundStats(Long id){
	     Long ID=Long.valueOf(session().get("id"));
		 User user=User.find.byId(ID);
		 if(user.getEmail().equals("admin@gmail.com"))
		 {
	     Project project=Project.find.byId(id);
		 return ok(fundStats.render(project));
		 }
		 else{
			 return forbidden("You are not authorized to view this page!");
		 }
		 
		
	}
		 

	/* This function shows the distribution of the projects based on the interest areas */
     public static Result tagStats(){
    	 Long ID=Long.valueOf(session().get("id"));
		 User user=User.find.byId(ID);
    	 if(!user.getEmail().equals("admin@gmail.com")){
    		 return forbidden("You are not authorized to view this page!");
    	 }
    	 
    	 Map<String,Integer> results=new HashMap<String,Integer>();
    		 List<Tag> tags=Tag.find.all();
    		 for (Tag tag:tags){
    		    for(Community community:tag.myCommunities){
    		    	results.put(tag.getName(), community.myprojects.size());
    		    }
    		 
    		 }
    		 
    		 
    		 if(results.isEmpty()){
    			 return notFound("No results to show");
    		 }
    		 
    		 return ok(tagStats.render(results));
    	
    	}
     
     
     public static Result login() {

		return ok(signin.render(LoginForm));

	}



	public static Result logout(){
		session().clear();
		return redirect(routes.Application.login());
	}


	public static Result authenticate(){

		Form<Application.Login> tmp=LoginForm.bindFromRequest(); 

		if (tmp.hasErrors()) {
			return badRequest(signin.render(tmp));
		} 

		else {



			return redirect(
					routes.Application.index()  // it should redirect to user's home page
					);
		}

	}  


	public static Result register(){

		return ok(register.render(UserForm));

	}


	public static Result createUser(){
		Form<User> tmp=UserForm.bindFromRequest(); 

		if (tmp.hasErrors()) {
			return badRequest(register.render(tmp));
		} 
		else {

			User user=tmp.get();   
			if(user.getEmail().contains("admin")){
				flash("error","Username not well-chosen!");
				return badRequest(register.render(tmp));
			}
			
		    User duplicate=User.find.where().eq("email", user.getEmail()).findUnique();
		    if(duplicate != null){
		    	flash("error","Username already in use!");
		    	return badRequest(register.render(tmp));
		    }
			
			
			MultipartFormData body = request().body().asMultipartFormData();
			MultipartFormData.FilePart part = body.getFile("picture");
			if(part!=null){

				File picture=part.getFile();
				try{
					user.picture=Files.toByteArray(picture);

				}
				catch(IOException e){
					return internalServerError("Error reading file upload");
				}
			}

			user.setCounter(0);
			user.setRating(0.0);
			
			flash("success","Congratutalions! You successfully registered!");	
			user.save();
			return redirect(
					routes.Application.login()
					);
		}

	}

	
	public static Result userDetail(Long id){
		User user=User.find.byId(id);
		return ok(userdetail.render(user));
	}
	
	
	public static Result newProject(Long ID){

		return ok(newproject.render(ID,ProjectForm));

	}


	public static Result createProject(Long ID) {
		Form<Project> tmp=ProjectForm.bindFromRequest(); 

		if (tmp.hasErrors()) {
			return badRequest(newproject.render(ID,tmp));
		} 
		else {
			Project project=tmp.get();
			
			User current= User.find.byId(Long.parseLong(session().get("id")));
			Community community=Community.find.byId(ID);
			
			project.setCounter(0);
			project.setRating(0.0);
			project.setInitiator(current);
			project.setMycommunity(community);
			project.save();
		    community.myprojects.add(project);

			current.myprojects.add(project);
			
			current.save();
			
			community.save();
			

			return redirect(
					routes.Application.index());

		}

	}

	public static Result projectDetail(Long id){
		Project project=Project.find.byId(id);
		return ok(projedetail.render(project));
	}

	public static Result delete (Long id){
		final Project project = Project.find.byId(id);
		if(project == null) {
			return notFound("Idea does not exists.");
		}
		project.delete();
		return ok("Idea has been deleted!");
	}
	

	public static Result  search(String tags){
		List<SampleCommunity> results=new ArrayList<SampleCommunity>();
		String[] listoftags=tags.split(" ");

		for(String name:listoftags){
			Tag tag=Tag.find.where().eq("name", name).findUnique();
			if(tag!=null){
				for(Community community:tag.myCommunities){
					SampleCommunity tmp=new SampleCommunity(community.id, community.getTitle(), community.getDescription(),community.tags);	
					results.add(tmp); 

				}
			}	
		}		


		if(results.isEmpty())
			return notFound("not found!");

		ObjectMapper mapper = new ObjectMapper(); 
		JsonNode node = mapper.convertValue(results, JsonNode.class);

		System.out.println(node); 
		return ok(node);
	}


	public static Result newfund(Long id){

		Project project=Project.find.byId(id);
		return ok(fund.render(project,FundForm));


	}


	public static Result fund(Long id){

		Form<Fund> tmp=FundForm.bindFromRequest(); 
		Fund fund=tmp.get();

		User current=User.find.byId(Long.valueOf(session().get("id")));
		Project project=Project.find.byId(id);

		fund.funder=current;
		fund.proje=project;
		project.whoFundedMe.add(fund);
		current.myfunds.add(fund);
		fund.save();
		current.save();
		project.save();
		flash("success","You successfully funded the project");

		return redirect(routes.Application.projectDetail(project.id));		

	}


	public static Result newCommunity(){
		return ok(newcommunity.render(CommunityForm));
	}

 
	public static Result createCommunity(){
		Form<Community> tmp=CommunityForm.bindFromRequest(); 

		if (tmp.hasErrors()) {
			return badRequest(newcommunity.render(tmp));
		} 
		else {

			User current=User.find.byId(Long.valueOf(session().get("id")));
			Community community=tmp.get(); 


			List<Tag> mytags=new ArrayList<Tag>();

			Tag tagish=null;

			String[] tagsArray=tmp.field("tags").value().split(" ");

			for (String tag : tagsArray){

				tagish= Tag.find.where().eq("name", tag).findUnique();
				if(tagish!=null) {
					tagish.myCommunities.add(community);
					mytags.add(tagish);


				}
				else  
				{
					tagish=new Tag();
					tagish.setName(tag);
					tagish.myCommunities.add(community);
					mytags.add(tagish);
				}

			} 

			current.myCommunities.add(community);
			community.myMembers.add(current);
			community.myTags=mytags;
			community.save();
			//current.save();

			return redirect(
					routes.Application.index()  // it should redirect to community details page
					);
		}
	}
    
	
	public static Result communityDetail(Long id){
		Community community=Community.find.byId(id);
		User currentUser=User.find.byId(Long.valueOf(session("id")));
		boolean flag=false;
		
		for(User user:community.myMembers){
			if(user.getEmail().equals(currentUser.getEmail()))
				flag=true;
		 }
		
		
		return ok(communitydetail.render(flag,community));
	}
	
	
	public static Result  follow(Long id){
		Community community=Community.find.byId(id);
		User current= User.find.byId(Long.parseLong(session().get("id")));
		current.myCommunities.add(community);
		community.myMembers.add(current);
		current.save();
		community.save();
	    return ok("Success");
	
	}
	
	
	
	
	public static Result picture(Long id) {

		final User user = User.find.byId(id);
		if(user == null) return notFound();
		return ok(user.picture);
	}


	public static Result rateUser (Long id, Integer vote){

		User userToBeRated= User.find.byId(id);

		userToBeRated.rate(vote);

		userToBeRated.save();

		return ok(String.valueOf(userToBeRated.getRating()));
	}

	public static Result rateProject (Long id,Integer vote){

		Project project=Project.find.byId(id);
		project.rate(vote);
		project.save();

		return ok(String.valueOf(project.getRating()));

	}


	public static Result reviewProject (Long id, String content){


		User currentUser=User.find.byId(Long.valueOf(session("id")));

		Project project=Project.find.byId(id);

		Review review=new Review();

		review.setContent(content);
		
		Date date = new Date();
		
	    review.setPostDate(date);
		review.author=currentUser;
		review.proj=project;

		currentUser.myReviews.add(review);
		project.myReviews.add(review);

		currentUser.save();
		project.save();
		review.save();
		return ok("success");

	}


	public static class Login {

		public String email;
		public String password;


		public String validate() {

			User user=User.authenticate(email, password);
			if ( user== null) {
				flash("error","Invalid username or password");
				return "Invalid user or password";
			}
			session().clear();
			session("id",Long.toString(user.id));
			return null;
		}


	}

}


