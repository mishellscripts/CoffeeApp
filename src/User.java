import java.util.ArrayList;

public class User {
	private String name;
	private String ID;
	private String password;
	private int numReviewed;
	private double balance;
	private ArrayList<?> favorites;
	private ArrayList<?> history;
	
	public User(String n, String i, String p) {
		name = n;
		ID = i;
		password = p;
		numReviewed = 0;
		balance = 0.0;
//		favorites = new ArrayList<?>();
//		history = new ArrayList<?>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public boolean checkPassword(String pass)
	{
		return password.equals(pass);
	}
	
	public String displayBalance()
	{
		String addZero = balance + "0";
		int decimalLoc = addZero.indexOf(".");
		return ("$" + addZero.substring(0, decimalLoc + 3));
	}
}
