import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order extends JFrame {

	//decorations instance variables
	Font fontB = new Font("serif", Font.BOLD, 24);
	Font font = new Font("plain17", Font.PLAIN, 16);
	Color lightTan = new Color(214, 174, 126);
	Color darkRed = new Color(124, 28, 30);
	
	public Order(CoffeeModel model)
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
		
		
		//
		JLabel label = new JLabel("order");
		label.setFont(fontB);
		mainPanel.add(label);
		
		
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

