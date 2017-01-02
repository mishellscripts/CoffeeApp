
public class CoffeeDemo {
	public static void main(String[] args) {
		CoffeeModel model = new CoffeeModel();
//		SignIn signIn = new SignIn(model);
//		model.signUp("Duitty", "duitty", "1");
		MainMenu test = new MainMenu(model);
		//dsd
		//comment here test
		// TEST SAD    
		//TEST SADDDDDD DUITTYYY
		
		
		
		double num = 1.1;
		String check = num + "0";
		int decimalLoc = check.indexOf(".");
		String result = "$" + check.substring(0, decimalLoc + 3);
		
		System.out.println(result);
	}
}
