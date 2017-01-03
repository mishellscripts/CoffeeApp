
public class CoffeeDemo {
	public static void main(String[] args) {
		CoffeeModel model = new CoffeeModel();
//		SignIn signIn = new SignIn(model);
//		SignUp signUp = new SignUp(model);
		model.signUp("Duitty", "duitty", "1");
		model.signIn("duitty", "1");
		MainMenu test = new MainMenu(model);
	}
}
