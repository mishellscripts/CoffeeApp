import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Refill extends JFrame {

	//decorations instance variables
	Font fontB = new Font("serif", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public Refill(CoffeeModel model)
	{	
		NavigationBar nav = new NavigationBar(model, this);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();

		//arrow for navigation bar
		JPanel arrowPanel = new JPanel();
		JButton arrow = new JButton("<<");
		arrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (arrow.getText().equals("<<"))
				{
					arrow.setText(">>");
					remove(nav);
				}
				else if (arrow.getText().equals(">>"))
				{
					arrow.setText("<<");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					c.weightx = 0.2;
					c.weighty = 1;
					c.ipady = 700;
					add(nav, c);
				}
			}
		});
		arrow.setFocusPainted(false);
		arrow.setContentAreaFilled(false);
		arrow.setBorder(new LineBorder(darkRed, 2, false));
		arrow.setFont(new Font("monospaced", Font.PLAIN, 14));
		arrowPanel.setLayout(new BorderLayout());
		arrowPanel.add(arrow, BorderLayout.WEST);
		
		
		//add navigation bar
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.2;
		c.weighty = 1;
		c.ipady = 700;
		add(nav, c);
		
		
		//add arrow for the navigation bar
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 1;
		add(arrowPanel, c);
		
		
		//main panel
		JPanel mainPanel = new JPanel();
		//setLayout
		
		
		//user's current balance
		mainPanel.setLayout(new GridLayout(7,1));
		mainPanel.add(new JLabel("\n"));
		
		JPanel balPanel = new JPanel();
		
		//show user's current balance
		String balance = model.getCurrentUser().displayBalance();
		JLabel balLabel = new JLabel(" " + balance);
		balLabel.setFont(fontB);
		balPanel.add(balLabel);
		mainPanel.add(balPanel);
		
		JPanel optionPanel = new JPanel();
		JButton refillButton = new JButton("Refill");
		refillButton.setFont(font);
		refillButton.setFocusPainted(false);
		refillButton.setContentAreaFilled(false);
		refillButton.setMargin(new Insets(10,10,10,10));
		refillButton.setBorder(new LineBorder(darkRed));
		
		optionPanel.add(refillButton);
		String[] refillAmounts = { "$5", "$10", "$25", "$50", "Custom" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox refillList = new JComboBox(refillAmounts);
		refillList.setFont(font);
		optionPanel.add(refillList);
		mainPanel.add(optionPanel);
		
		//add main panel
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(mainPanel, c);


		setSize(500, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

