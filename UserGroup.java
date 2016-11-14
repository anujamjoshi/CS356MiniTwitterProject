import java.util.ArrayList;


public class UserGroup extends TwitterUser{
	String id;
	ArrayList <User> groupUser = new ArrayList<>(); 
	// the groups contain users and they can have 

	public UserGroup(String id){
		setID(id);
	}
	/*
	 * adds the
	 */
	public void addUsers(String id){
		User u = new User(id);
		groupUser.add(u);
		u.addGroup(this);

	}
	/*
	 * Implementing the Twitter User methods  
	 */
	@Override
	public String getID() {

		return id;
	}

	@Override
	public void setID(String id) {
		this.id=id;

	}

	@Override
	public String toString() {

		return this.getID();
	}

}

