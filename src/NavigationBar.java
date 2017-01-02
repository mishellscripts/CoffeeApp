import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class NavigationBar extends JPanel
{
	
	//decorations instance variables
	Font fontB = new Font("plain17", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public NavigationBar(CoffeeModel model)
	{	
//		setLayout(new GridLayout(0, 1));
		setBorder(new LineBorder(darkRed, 3, false));
		FlowLayout layout = (FlowLayout) this.getLayout();
		layout.setHgap(-30);
		
		//logo
		JPanel logoPanel = new JPanel();
		Logo logo = new Logo(65, 65);
		JButton logoButton = new JButton(logo);
		logoButton.setFocusPainted(false);
		logoButton.setContentAreaFilled(false);
		logoButton.setBorderPainted(false);
		logoPanel.add(logoButton);
		add(logoPanel);
		
		
		//button options
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 1));
		
	
		setSize(100, 700);
	}
}
