import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBar extends JPanel
{
	JFrame currentFrame;
	
	//decorations instance variables
	Font fontB = new Font("serif", Font.BOLD, 24);
	Font font = new Font("plain", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public NavigationBar(CoffeeModel model, JFrame frame)
	{	
		currentFrame = frame;
		setBorder(new LineBorder(darkRed, 3, false));
		FlowLayout layout = (FlowLayout) this.getLayout();
		layout.setHgap(-30);
		
		//main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		
		//logo
		Logo logo = new Logo(65, 65);
		JButton logoButton = new JButton(logo);
		logoButton.setFocusPainted(false);
		logoButton.setContentAreaFilled(false);
		logoButton.setBorderPainted(false);
		logoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				MainMenu frame = new MainMenu(model);
			}
		});
		mainPanel.add(logoButton);
		
		
		//show user's current balance
		String balance = model.getCurrentUser().displayBalance();
		JLabel balLabel = new JLabel(" " + balance);
		balLabel.setFont(fontB);
		mainPanel.add(balLabel);
		
		
		//
		
		
		add(mainPanel);
	
		setSize(100, 700);
	}
	
	public void setCurrentFrame(JFrame frame)
	{
		currentFrame = frame;
	}
}
