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


		//refill button
		JButton refillButton = new JButton("Refill");
		refillButton.setFocusPainted(false);
		refillButton.setContentAreaFilled(false);
		refillButton.setBorder(new LineBorder(darkRed, 2, false));
		refillButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		refillButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				//				Refill frame = new Refill(model);
			}
		});
		mainPanel.add(refillButton);
//		mainPanel.add(new JLabel("\n"));


		//order button
		JButton orderButton = new JButton("Order");
		orderButton.setFocusPainted(false);
		orderButton.setContentAreaFilled(false);
		orderButton.setBorder(new LineBorder(darkRed, 2, false));
		orderButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		orderButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				//
			}
		});
		mainPanel.add(orderButton);
		
		
		//favorites button
		JButton favButton = new JButton("Favorites");
		favButton.setFocusPainted(false);
		favButton.setContentAreaFilled(false);
		favButton.setBorder(new LineBorder(darkRed, 2, false));
		favButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		favButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				//
			}
		});
		mainPanel.add(favButton);
		
		
		//history button
		JButton histButton = new JButton("History");
		histButton.setFocusPainted(false);
		histButton.setContentAreaFilled(false);
		histButton.setBorder(new LineBorder(darkRed, 2, false));
		histButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		histButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				//
			}
		});
		mainPanel.add(histButton);
		
		
		//settings button
		JButton setButton = new JButton("Settings");
		setButton.setFocusPainted(false);
		setButton.setContentAreaFilled(false);
		setButton.setBorder(new LineBorder(darkRed, 2, false));
		setButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		setButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				//
			}
		});
		mainPanel.add(setButton);
		
		
		//sign out button
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setFocusPainted(false);
		signOutButton.setContentAreaFilled(false);
		signOutButton.setBorder(new LineBorder(darkRed, 2, false));
		signOutButton.setFont(new Font("monospaced", Font.PLAIN, 14));
		signOutButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.dispose();
				model.signOut();
				SignIn signIn = new SignIn(model);
			}
		});
		mainPanel.add(signOutButton);


		add(mainPanel);
		setSize(100, 700);
	}

	public void setCurrentFrame(JFrame frame)
	{
		currentFrame = frame;
	}
}
