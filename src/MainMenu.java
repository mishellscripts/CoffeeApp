import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
	
	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color darkBlue = new Color(62, 89, 130);	
	
	public MainMenu(CoffeeModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		
		//logo
		JPanel logoPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				Logo logo = new Logo();
				logo.draw(g2);
			}
		};
		logoPanel.setSize(new Dimension(200, 200));
		JTextArea space = new JTextArea("\n\n\n\n\n\n\n\n\n\n\n");
		space.setEditable(false);
		logoPanel.add(space);
		add(logoPanel);
		
		
		
	
		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

