package controllers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.io.Files;

import models.*;
import play.Play;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import views.html.*;
import play.cache.Cache;


public class Application extends Controller {

		private static final Form<Application.Login> LoginForm =
		      Form.form(Application.Login.class);
		private static final Form <User> UserForm=
		 	  Form.form(User.class);
		private static final Form <Community> CommunityForm=
		 	  Form.form(Community.class);
 
		private static final Form<Project> ProjectForm=
		 	  Form.form(Project.class);
 
 
	
	
	
 @Security.Authenticated(Secured.class)	

 	
    public static Result index(){
		return ok(profile.render());
	}
	
    public static Result login() {
        
    	return ok(signin.render(LoginForm));
       
    }
	
	
	public static Result register(){
		   
		   return ok(register.render());
		   
	   }
	  
	public static Result createUser(){
		   Form<User> tmp=UserForm.bindFromRequest(); 
		   
	  	 if (tmp.hasErrors()) {
	  	        return badRequest();
	  	    } 
	  	       else {
	  	        
	  	    	User user=tmp.get();   
	  	    	
	  	    	
	  	    	/*
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
	  	    	
	  	        */
	  	        
	  	    	flash("success","Congratutalions! You successfully registered!");	
	  	    	user.save();
	  	        return redirect(
	  	            routes.Application.login()
	  	        );
	  	    }
		   
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

 	
 
    public static Result picture(Long id) {

 	     final User user = User.find.byId(id);
 	     if(user == null) return notFound();
 	     return ok(user.picture);
 	}
 
 	
 	public static Result rateUser (Long id, Integer vote ){

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
 	
 	
 	public static Result reviewProject (Long id, String content, Date dateOfReview){
 		
 		User currentUser= (User) Cache.get(session().get("id"));
 		if(currentUser==null){
 			currentUser=User.find.byId(Long.valueOf(session("id")));
 		}
 		
 		Project project=Project.find.byId(id);
 		
 		Review review=new Review();
 		
 		review.setContent(content);
 		review.setPostDate(dateOfReview);
 		review.author=currentUser;
 		review.proj=project;
 		
 		currentUser.myReviews.add(review);
 		
 		project.myReviews.add(review);
 		
 		currentUser.save();
 		project.save();
 		review.save();
 		
 		/* Not sure about this */
 		Cache.remove(session().get("id"));
 		Cache.set(session().get("id"), currentUser);
 		
 		return ok("success");
 		
 		}

 
   
   /*
 	
 	public static Result newProject(){
    	   
        return ok(newproject.render(ProjectForm));
    
   }
    
  
   
 	
 	public static Result createProject() {
	 Form<Project> tmp=ProjectForm.bindFromRequest(); 
		  
  	 if (tmp.hasErrors()) {
  	        return badRequest(newproject.render(tmp));
  	    } 
  	  else {
  	         Project project=tmp.get();
  	         User current= User.find.byId(Long.parseLong(session().get("id")));
  	         
  	         
  	         project.save();
  		     return redirect(
  	            routes.Application.index() );
  	        
  	    }
	   
   }
  
  
  
 	
 	
 	public static Result newCommunity(){
	   return ok(newcommunity.render(CommunityForm));
   }
    
 
 	
 	public static Result createCommunity(String tags){
	 Form<Community> tmp=CommunityForm.bindFromRequest(); 
		  
  	 if (tmp.hasErrors()) {
  	        return badRequest(newcommunity.render(tmp));
  	    } 
  	 else {
  	        
  		 Community community=tmp.get();   
  		 Tag tagish=null;
  		 
  		 String[] tagsArray=tags.split(",");
  		 
  		 for (String tag : tagsArray){
  			 
  		      tagish= Tag.find.where().eq("name", tag).findUnique();
  		      if(tagish!=null) {
  		    	  community.myTags.add(tagish);
  		    	  tagish.community=community;
  		    	  
  		      }
  		     else  
  		         {
  		    	  tagish=new Tag();
  		    	  tagish.setName(tag);
  		    	  tagish.community=community;
  		    	  community.myTags.add(tagish);
  		         }
  		    	 
  		    } 
  	    	  
  		   User current =(User) Cache.get(session().get("id"));
  		    
  		   if(current==null){
  		    	current=User.find.byId(Long.valueOf(session().get("id")));
  		    }
  		    
  		    community.getMyMembers().add(current);
  		    current.myCommunities.add(community);
  		    
  		    
  		    community.save();
  		    current.save();
  		    tagish.save();
  		    
  		    Cache.set(session().get("id"), current);
  		    
  		    
  		    return redirect(
  	            routes.Application.index()  // it should redirect to community details page
  	        );
  	    }
   
   
   
   }
   */
 
 	public static class Login {

    	 public String email;
 	     public String password;
    	  
    	 
    	 public String validate() {
    		    
    		   User user=User.authenticate(email, password);
    		   if ( user== null) {
    		    	return "Invalid user or password";
    		      }
    		   
    		   
    		   
    		   session().clear();
    		   session("id",Long.toString(user.id));
    		              
    		   System.out.println(user.getEmail());
    		   
    		 
    		   Cache.set(session().get("id"),user,10*60);
    		   return null;
    		}
    	    

    	}

}


