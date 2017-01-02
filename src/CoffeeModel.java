import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class CoffeeModel {
	
	private User currentUser;
	private ArrayList<User> users;
	private ArrayList<ChangeListener> listeners;
	
	public CoffeeModel() {
		users = new ArrayList<User>();
		listeners = new ArrayList<ChangeListener>();
	}
	
	public void signUp(String name, String ID, String password) {
		User user = new User(name, ID, password);
		users.add(user);
	}
	
	public boolean signIn(String ID, String password) {
		boolean found = false;
		for (User user : users) {
			if(user.getID().equals(ID) && user.checkPassword(password)) {
				currentUser = user;
				found = true;
				break;
			}
		}
		return found;
	}
	
	public boolean checkIfUnusedID(String ID)
	{
		for(User user : users)
		{
			String checkID = user.getID().toLowerCase();
			String desiredID = ID.toLowerCase();
			if(checkID.equals(desiredID)) return false;
		}
		return true;
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	

} 
