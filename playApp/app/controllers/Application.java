package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Application extends Controller {


    public static Result index() {
        return ok(index.render()); 
    }

    public static Result register() {
        return ok(register.render()); 
    }

    public static Result userRegister() {
        User user = Form.form(User.class).bindFromRequest().get();
        user.save();
        return redirect(
                routes.Application.setUpProfile());
    }

    public static Result signin() {
        return ok(
            signin.render(form(Login.class))
        );
    }

	public static class Login {
    	public String email;
    	public String password;

    	public String validate() {
		    if (User.authenticate(email, password) == null) {
		      return "Invalid user or password";
		    }
		    return null;
		}

	} //End of Loging class

	public static Result authenticate() {
    	Form<Login> loginForm = form(Login.class).bindFromRequest();
    	if (loginForm.hasErrors()) {
	        return badRequest(signin.render(loginForm));
	    } else {
	        session().clear();
	        session("email", loginForm.get().email);
	        return redirect(
	            routes.Application.index());
	    }
	}

	public static Result profileSetUp() {
        return ok(profileSetUp.render()); 
    }

    public static Result signOut() {
	    session().clear();
	    flash("success", "You've been logged out");
	    return redirect(
	        routes.Application.index());
	}

	public static Result setUpProfile() {
        return ok(profileSetUp.render()); 
    }

	public static Result profile() {
        return ok(profile.render()); 
    }

    public static Result othersProfileView() {
        return ok(othersProfileView.render()); 
    }

    public static Result exploreCommunity() {
        return ok(exploreCommunity.render()); 
    }
    
    public static Result creatingCommunity() {
        return ok(creatingCommunity.render()); 
    }

    public static Result communityPage() {
        return ok(communityPage.render()); 
    }

    public static Result projectCreation() {
        return ok(projectCreation.render()); 
    }

    public static Result project() {
        return ok(project.render()); 
    }

    public static Result fund() {
        return ok(fund.render()); 
    }

    public static Result myFriends() {
        return ok(myFriends.render()); 
    }

    public static Result myCommunities() {
        return ok(myCommunities.render()); 
    }

    public static Result myProjects() {
        return ok(myProjects.render()); 
    }

    public static Result fundedProjects() {
        return ok(fundedProjects.render()); 
    }

    public static Result publicFriend() {
        return ok(publicFriend.render()); 
    }

    public static Result publicCommunities() {
        return ok(publicCommunities.render()); 
    }

    public static Result publicProjects() {
        return ok(publicProjects.render()); 
    }

    public static Result publicFunded() {
        return ok(publicFunded.render()); 
    }

    public static Result communityMembers() {
        return ok(communityMembers.render()); 
    }

    public static Result communityProjects() {
        return ok(communityProjects.render()); 
    }

    public static Result inviteFriends() {
        return ok(inviteFriends.render()); 
    }

}
